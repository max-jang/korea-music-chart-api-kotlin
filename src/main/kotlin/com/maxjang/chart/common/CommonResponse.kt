package com.maxjang.chart.common

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공통 API 응답 모델")
data class CommonResponse<T>(
    @Schema(description = "HTTP 상태 코드", example = "200")
    val code: Int,

    @Schema(description = "상태 메시지", example = "OK")
    val status: String,

    @Schema(description = "응답 데이터")
    val data: T?
)
