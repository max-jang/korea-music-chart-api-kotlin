package com.maxjang.chart.common

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "음악 차트 응답 데이터")
data class MusicChartResponse<T>(
    @Schema(description = "응답 코드", example = "200")
    val code: Int,

    @Schema(description = "응답 상태", example = "OK")
    val status: String,

    @Schema(description = "음악 차트 데이터 목록")
    val data: T?
)