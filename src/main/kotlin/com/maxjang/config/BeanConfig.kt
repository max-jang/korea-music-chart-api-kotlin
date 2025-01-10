package com.maxjang.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * 공통 Bean 설정 클래스
 */
@Configuration
class BeanConfig {
    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder.build()
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
            .registerKotlinModule() // Kotlin 모듈 등록
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE) // 스네이크 -> 카멜 자동 변환
    }
}
