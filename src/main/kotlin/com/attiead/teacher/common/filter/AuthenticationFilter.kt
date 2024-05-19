package com.attiead.teacher.common.filter

import com.attiead.teacher.common.model.MetaCode
import com.attiead.teacher.common.response.Meta
import com.attiead.teacher.common.response.ResponseDTO
import com.attiead.teacher.domain.service.user.UserQueryService
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter

class AuthenticationFilter(
    private val objectMapper: ObjectMapper,
    private val userQueryService: UserQueryService
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationToken = request.getHeader(HttpHeaders.AUTHORIZATION)
        val userDTO = userQueryService.existUser(token = authorizationToken)

        if (userDTO == null) {
            createErrorResponse(response = response)
            return
        }

        doFilter(request, response, filterChain)
    }

    private fun createErrorResponse(response: HttpServletResponse) {
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.characterEncoding = Charsets.UTF_8.displayName()
        response.writer.write(createUnauthorizedResponse())
    }

    private fun createUnauthorizedResponse(): String = objectMapper.writeValueAsString(
        ResponseDTO<Unit>(
            meta = Meta(
                MetaCode.AUTHENTICATION_FAILED,
                message = "인증에 실패하였습니다."
            )
        )
    )
}
