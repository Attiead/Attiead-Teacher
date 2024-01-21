package com.attiead.teacher.domain.table

import com.attiead.teacher.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "teachers_certificates")
class TeacherCertificate(
    @Column(name = "teacher_id")
    val teacherId: String,

    @Column(name = "certificate_id")
    val certificateId: String,

) : BaseEntity()
