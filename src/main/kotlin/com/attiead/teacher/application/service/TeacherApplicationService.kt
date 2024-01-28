package com.attiead.teacher.application.service

import com.attiead.teacher.application.dto.RequestCreateTeacherDTO
import com.attiead.teacher.domain.service.TeacherCrudService
import org.springframework.stereotype.Service

@Service
class TeacherApplicationService(
    private val teacherCrudService: TeacherCrudService
) {

    fun createTeacher(
        requestCreateTeacherDTO: RequestCreateTeacherDTO
    ) {
        teacherCrudService.register(
            requestCreateTeacherDTO.toEntity()
        )
    }
}
