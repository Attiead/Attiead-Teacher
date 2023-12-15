package com.attiead.teacher.attieadteacher.common.exception

import com.attiead.teacher.attieadteacher.common.model.MetaCode

open class BaseHttpException(
    val metaCode: MetaCode = MetaCode.INTERNAL_SERVER_ERROR,
    override var message: String? = null,
    val data: Any? = null
) : RuntimeException()
