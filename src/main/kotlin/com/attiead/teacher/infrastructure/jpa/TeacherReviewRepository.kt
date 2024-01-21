package com.attiead.teacher.infrastructure.jpa

import com.attiead.teacher.common.entity.ID
import com.attiead.teacher.domain.table.TeacherReview
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherReviewRepository :
    JpaRepository<TeacherReview, ID>
