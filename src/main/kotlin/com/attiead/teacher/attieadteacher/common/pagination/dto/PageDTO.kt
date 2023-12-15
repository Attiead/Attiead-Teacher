package com.attiead.teacher.attieadteacher.common.pagination.dto

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

class PageDTO(
    val currentPageNumber: Int = 0,
    val currentPageSize: Int = 10,
    var sortOrder: Sort = Sort.unsorted(),
) : PageRequest(currentPageNumber, currentPageSize, sortOrder) {

    companion object {
        fun of(pageNumber: Int, pageSize: Int, sort: Sort? = null): PageDTO {
            return PageDTO(
                currentPageNumber = convertToServerPage(pageNumber),
                currentPageSize = pageSize,
                sortOrder = sort ?: Sort.unsorted(),
            )
        }

        private fun convertToServerPage(requestPageNumber: Int): Int {
            return if (requestPageNumber <= 0) {
                0
            } else {
                requestPageNumber - 1
            }
        }
    }

    fun updateSortOrder(newSort: Sort) {
        this.sortOrder = newSort
    }
}
