package com.attiead.teacher.application.service

import com.attiead.teacher.application.dto.RequestCreateTeacherDTO
import com.attiead.teacher.common.openfeign.UserClient
import com.attiead.teacher.domain.service.TeacherCrudService
import org.springframework.stereotype.Service

@Service
class TeacherApplicationService(
    private val teacherCrudService: TeacherCrudService,
    private val userClient: UserClient
) {

    fun createTeacher(
        requestCreateTeacherDTO: RequestCreateTeacherDTO
    ) {
        userClient.checkExistUser(requestCreateTeacherDTO.uid)
        teacherCrudService.register(
            requestCreateTeacherDTO.toEntity()
        )
    }
}
