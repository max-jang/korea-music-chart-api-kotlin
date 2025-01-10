package com.maxjang.chart.melon

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 멜론 차트 API 응답 데이터 모델
 */
@Schema(description = "멜론 차트 API 응답 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class MelonChartResponse(
    @JsonProperty("response")
    val response: MelonChartResponseBody
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MelonChartResponseBody(
    @JsonProperty("SONGLIST")
    val songList: List<MelonChartItem>
)