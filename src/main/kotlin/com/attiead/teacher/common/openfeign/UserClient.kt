package com.attiead.teacher.common.openfeign

import com.attiead.teacher.application.dto.ResponseUserDTO
import com.attiead.teacher.common.response.ResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    value = "user",
    url = "\${external-api.user.url}",
    configuration = [DefaultConfiguration::class]
)
interface UserClient {

    @GetMapping("/api/v1/users/{uid}")
    fun checkExistUser(
        @PathVariable("uid") uid: String
    ): ResponseDTO<ResponseUserDTO>

    @GetMapping("/api/v1/users/authorize")
    fun getUser(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) token: String
    ): ResponseDTO<String>
}
