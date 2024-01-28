package com.attiead.teacher.common.openfeign

import com.attiead.teacher.application.dto.ResponseUserDTO
import com.attiead.teacher.common.response.ResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(value = "user", url = "\${external-api.user.url}")
interface UserClient {

    @GetMapping(value = ["/api/v1/users/{uid}"])
    fun checkExistUser(
        @PathVariable("uid") uid: String
    ): ResponseDTO<ResponseUserDTO>
}
