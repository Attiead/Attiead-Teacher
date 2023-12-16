package com.attiead.teacher.common.response

import com.attiead.teacher.common.model.MetaCode

data class Meta(
    val code: MetaCode,
    val type: String? = code.name,
    val message: String? = null,
)
