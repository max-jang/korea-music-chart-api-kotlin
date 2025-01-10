package com.maxjang.chart.genie

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 지니뮤직 차트 API 응답 데이터 모델
 */
@Schema(description = "지니뮤직 차트 API 응답 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenieChartResponse(
    @Schema(description = "차트 데이터 세트")
    @JsonProperty("DataSet")
    val dataSet: GenieDataSet
)