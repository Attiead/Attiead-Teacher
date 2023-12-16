package com.attiead.teacher.common.pagination.dto

import org.springframework.data.domain.Page

data class PaginationDataDTO<T, D>(
    val page: Page<T>,
    val data: D,
)
