package com.attiead.teacher.attieadteacher.common.exception

import com.attiead.teacher.attieadteacher.common.model.MetaCode

class UnprocessableException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.BAD_REQUEST,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
