package com.attiead.teacher.infrastructure.jpa

import com.attiead.teacher.common.entity.ID
import com.attiead.teacher.domain.table.Certificate
import org.springframework.data.jpa.repository.JpaRepository

interface CertificateRepository :
    JpaRepository<Certificate, ID>
