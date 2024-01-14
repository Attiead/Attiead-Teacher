package com.attiead.teacher.domain.table

import com.attiead.teacher.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "teacher_review")
class TeacherReview(
    @Column(name = "teacher_id")
    val teacherId: String,

    @Column(name = "review_id")
    val reviewId: String,

) : BaseEntity()
