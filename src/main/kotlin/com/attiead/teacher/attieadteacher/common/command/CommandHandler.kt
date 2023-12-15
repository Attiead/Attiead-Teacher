package com.attiead.teacher.attieadteacher.common.command

interface CommandHandler<T> where T : Command {
    fun handle(message: T)
}
