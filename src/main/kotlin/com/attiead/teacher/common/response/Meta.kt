package com.attiead.teacher.common.response

import com.attiead.teacher.common.model.MetaCode

data class Meta(
    val type: MetaCode,
    val code: String? = type.code,
    val message: String? = null,
)
