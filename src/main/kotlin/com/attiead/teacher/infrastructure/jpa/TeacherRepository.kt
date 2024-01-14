package com.attiead.teacher.infrastructure.jpa

import com.attiead.teacher.common.entity.ID
import com.attiead.teacher.domain.table.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository :
    JpaRepository<Teacher, ID>
