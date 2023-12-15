package com.attiead.teacher.attieadteacher.common.response

import com.attiead.teacher.attieadteacher.common.model.MetaCode

data class Meta(
    val code: MetaCode,
    val type: String? = code.name,
    val message: String? = null,
)
