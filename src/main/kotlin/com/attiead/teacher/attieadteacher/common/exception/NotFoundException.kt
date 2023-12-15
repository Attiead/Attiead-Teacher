package com.attiead.teacher.attieadteacher.common.exception

import com.attiead.teacher.attieadteacher.common.model.MetaCode

class NotFoundException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.NOT_FOUND,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
