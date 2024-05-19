package com.attiead.teacher.domain.service.teacher

import com.attiead.teacher.domain.table.Teacher
import com.attiead.teacher.infrastructure.jpa.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(
    private val teacherRepository: TeacherRepository
) : TeacherCrudService {

    override fun register(teacher: Teacher) {
        teacherRepository.save(teacher)
    }
}
