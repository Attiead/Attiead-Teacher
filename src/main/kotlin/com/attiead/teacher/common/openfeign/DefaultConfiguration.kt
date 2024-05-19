package com.attiead.teacher.common.openfeign

import feign.Logger
import feign.Retryer
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DefaultConfiguration {
    @Bean
    fun customLogger(): Logger {
        return FeignClientCustomLogger()
    }

    @Bean
    fun defaultRetryPolicy(): Retryer {
        return Retryer.Default()
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return CustomErrorDecoder()
    }
}
