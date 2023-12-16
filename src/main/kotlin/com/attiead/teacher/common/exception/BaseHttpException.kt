package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode

open class BaseHttpException(
    val metaCode: MetaCode = MetaCode.INTERNAL_SERVER_ERROR,
    override var message: String? = null,
    val data: Any? = null
) : RuntimeException()
