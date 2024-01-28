package com.attiead.teacher.application.dto

import com.attiead.teacher.domain.table.Teacher
import com.attiead.teacher.domain.vo.GraduateStatus
import com.attiead.teacher.domain.vo.Location
import com.attiead.teacher.domain.vo.Major
import com.attiead.teacher.domain.vo.Subject
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class RequestCreateTeacherDTO(
    @field:NotBlank
    val uid: String,
    val profileImageFilePath: String?,
    @field:NotBlank
    val university: String,
    @field:NotNull
    val major: Major,
    @field:NotNull
    val subject: Subject,
    @field:NotNull
    val graduateStatus: GraduateStatus,
    val portfolioFilePath: String?,
    val introduce: String?,
    @field:NotNull
    val career: Int,
    @field:NotNull
    val location: Location,
) {

    fun toEntity(): Teacher {
        return Teacher(
            uid = uid,
            profileImageFilePath = profileImageFilePath ?: "",
            university = university,
            major = major,
            subject = subject,
            graduateStatus = graduateStatus,
            portfolioFilePath = portfolioFilePath ?: "",
            introduce = introduce ?: "",
            career = career,
            location = location
        )
    }
}
