package com.attiead.teacher.domain.table

import com.attiead.teacher.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "certificates")
class Certificate(
    @Column(name = "file_path")
    val filePath: String? = null,

) : BaseEntity()
