package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode

class NotFoundException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.NOT_FOUND,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
