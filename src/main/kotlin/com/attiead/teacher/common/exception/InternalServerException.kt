package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode

class InternalServerException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.INTERNAL_SERVER_ERROR,
    message = message,
    data = data
)
