package com.attiead.teacher.common.exception

import com.attiead.teacher.common.model.MetaCode
import org.springframework.http.HttpStatus

class RemoteCallException(
    val remoteStatus: HttpStatus? = null,
    val remoteMessage: String? = null
) : BaseHttpException(
    metaCode = MetaCode.INTERNAL_SERVER_ERROR,
    message = "$remoteStatus : $remoteMessage"
)
