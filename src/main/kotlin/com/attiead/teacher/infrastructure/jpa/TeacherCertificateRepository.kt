package com.attiead.teacher.infrastructure.jpa

import com.attiead.teacher.common.entity.ID
import com.attiead.teacher.domain.table.TeacherCertificate
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherCertificateRepository :
    JpaRepository<TeacherCertificate, ID>{
}
