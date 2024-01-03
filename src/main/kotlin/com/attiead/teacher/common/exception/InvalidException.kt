package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode

class InvalidException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.BAD_REQUEST,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
