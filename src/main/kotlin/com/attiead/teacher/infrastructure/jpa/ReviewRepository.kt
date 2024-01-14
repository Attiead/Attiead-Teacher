package com.attiead.teacher.infrastructure.jpa

import com.attiead.teacher.common.entity.ID
import com.attiead.teacher.domain.table.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository :
    JpaRepository<Review, ID>  {
}
