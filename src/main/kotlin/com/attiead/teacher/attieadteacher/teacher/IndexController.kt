package com.attiead.teacher.attieadteacher.teacher

import com.attiead.teacher.attieadteacher.common.constant.VERSION
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun index() = "Attiead-Teacher $VERSION"
}
