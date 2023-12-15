package com.attiead.teacher.attieadteacher.common.pagination.dto.response

import com.attiead.teacher.attieadteacher.common.model.MetaCode
import com.attiead.teacher.attieadteacher.common.response.AbstractResponseDTO
import com.attiead.teacher.attieadteacher.common.response.Meta
import org.springframework.data.domain.Page

class PageResponseDTO<T>(
    val pagination: Pagination,
    override val data: Collection<T>,
    override val meta: Meta,
) : AbstractResponseDTO<Collection<T>>(meta, data) {

    companion object {
        fun <E, T : Any> pageSuccess(page: Page<E>, data: Collection<T> = emptyList()): PageResponseDTO<T> =
            PageResponseDTO(
                pagination = Pagination(
                    pageNumber = page.number + 1,
                    pageSize = page.size,
                    totalPage = page.totalPages,
                    totalCount = page.totalElements
                ),
                data = data,
                meta = Meta(MetaCode.SUCCESS),
            )
    }

    data class Pagination(
        val pageNumber: Int,
        val pageSize: Int,
        val totalPage: Int,
        val totalCount: Long,
    )
}
