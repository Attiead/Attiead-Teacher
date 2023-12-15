package com.attiead.teacher.attieadteacher.common.pagination.dto

import org.springframework.data.domain.Page

data class PaginationDataDTO<T, D>(
    val page: Page<T>,
    val data: D,
)
