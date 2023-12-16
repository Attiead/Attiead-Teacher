package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode

class ConflictException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.CONFLICT,
    message = message,
    data = data
)
