package com.attiead.teacher.teacher.application.rest

import com.attiead.teacher.common.constant.VERSION
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun index() = "Attiead-Teacher $VERSION"
}
