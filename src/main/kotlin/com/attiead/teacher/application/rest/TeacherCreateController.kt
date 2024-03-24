package com.attiead.teacher.application.rest

import com.attiead.teacher.application.dto.RequestCreateTeacherDTO
import com.attiead.teacher.application.service.TeacherApplicationService
import com.attiead.teacher.common.response.ResponseDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/teacher")
class TeacherCreateController(
    private val teacherApplicationService: TeacherApplicationService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createTeacher(
        @Valid @RequestBody
        requestCreateTeacherDTO: RequestCreateTeacherDTO
    ): ResponseDTO<Unit> {
        teacherApplicationService.createTeacher(
            requestCreateTeacherDTO
        )

        return ResponseDTO.success()
    }
}
