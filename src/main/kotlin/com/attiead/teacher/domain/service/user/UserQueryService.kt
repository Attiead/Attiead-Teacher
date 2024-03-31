package com.attiead.teacher.domain.service.user

import com.attiead.teacher.domain.service.user.dto.UserDTO

interface UserQueryService {

    fun existUser(token: String): UserDTO?
}
