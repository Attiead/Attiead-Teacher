package com.attiead.teacher.common.config

import com.attiead.teacher.common.filter.AuthenticationFilter
import com.attiead.teacher.domain.service.user.UserQueryService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebConfig {

    @Bean
    fun filterRegistrationBean(
        userQueryService: UserQueryService,
        objectMapper: ObjectMapper,
    ): FilterRegistrationBean<AuthenticationFilter> {
        val authenticationFilter = AuthenticationFilter(
            userQueryService = userQueryService,
            objectMapper = objectMapper
        )
        val filterRegistrationBean = FilterRegistrationBean<AuthenticationFilter>()
        filterRegistrationBean.filter = authenticationFilter
        filterRegistrationBean.addUrlPatterns("/api/v1/*")
        return filterRegistrationBean
    }
}
