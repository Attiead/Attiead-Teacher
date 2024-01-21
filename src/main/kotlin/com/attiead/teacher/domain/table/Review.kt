package com.attiead.teacher.domain.table

import com.attiead.teacher.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "reviews")
class Review(
    @Column(name = "score")
    val score: Int = 0,

    @Column(name = "comment")
    val comment: String? = null,
) : BaseEntity()
