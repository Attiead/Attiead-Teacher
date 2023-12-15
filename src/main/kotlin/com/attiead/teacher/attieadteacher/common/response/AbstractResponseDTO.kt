package com.attiead.teacher.attieadteacher.common.response

@Suppress("UnnecessaryAbstractClass")
abstract class AbstractResponseDTO<T>(
    open val meta: Meta,
    open val data: T? = null,
)
