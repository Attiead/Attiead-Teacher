package com.attiead.teacher.common.command

interface CommandHandler<T> where T : Command {
    fun handle(message: T)
}
