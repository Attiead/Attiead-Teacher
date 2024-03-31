package com.attiead.teacher.application.dto

data class ResponseUserDTO(
    val uid: String?,
    val email: String?,
    val password: String?,
    val grade: String?,
    val status: String?,
    val role: String?,
    val name: String?,
    val nickname: String?,
    val visibility: String?
)
