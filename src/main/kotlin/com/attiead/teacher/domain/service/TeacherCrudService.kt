package com.attiead.teacher.domain.service

import com.attiead.teacher.domain.table.Teacher

interface TeacherCrudService {

    fun register(
        teacher: Teacher
    )
}
