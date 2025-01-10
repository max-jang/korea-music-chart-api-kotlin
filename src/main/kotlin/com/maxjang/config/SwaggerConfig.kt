package com.maxjang.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI().info(
            Info()
                .title("Korea Music Chart API")
                .description("한국 음악 스트리밍 서비스 실시간 차트 API")
                .version("1.0.0")
        )
    }
}
