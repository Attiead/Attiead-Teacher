package com.attiead.teacher.domain.service.user

import com.attiead.teacher.common.openfeign.UserClient
import com.attiead.teacher.domain.service.user.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userClient: UserClient
) : UserQueryService {
    override fun existUser(token: String): UserDTO? {
        val responseDTO = userClient.getUser(token = token)
        return responseDTO.data?.let {
            UserDTO(uid = it)
        }
    }
}
