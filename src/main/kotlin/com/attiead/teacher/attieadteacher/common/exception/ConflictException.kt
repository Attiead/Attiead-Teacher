package com.attiead.teacher.attieadteacher.common.exception

import com.attiead.teacher.attieadteacher.common.model.MetaCode

class ConflictException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.CONFLICT,
    message = message,
    data = data
)
