package com.attiead.teacher.common.mapper

import com.attiead.teacher.application.dto.RequestCreateTeacherDTO
import com.attiead.teacher.domain.table.Teacher
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(
    componentModel = "spring"
)
interface TeacherEntityMapper {

    companion object {
        val INSTANCE: TeacherEntityMapper = Mappers.getMapper(TeacherEntityMapper::class.java)
    }

    @Mapping(target = "tid", ignore = true)
    fun toTeacherEntity(requestCreateTeacherDTO: RequestCreateTeacherDTO): Teacher
}
