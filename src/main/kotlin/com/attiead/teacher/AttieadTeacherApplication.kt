package com.attiead.teacher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients(basePackages = ["com.attiead.teacher.common.openfeign"])
@SpringBootApplication
class AttieadTeacherApplication

fun main(args: Array<String>) {
    runApplication<AttieadTeacherApplication>(*args)
}
