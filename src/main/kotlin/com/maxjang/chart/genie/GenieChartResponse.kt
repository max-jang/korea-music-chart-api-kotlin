package com.maxjang.chart.genie

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ArraySchema
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

@Schema(description = "지니뮤직 차트 데이터 세트")
data class GenieDataSet(
    @Schema(
        description = "차트 항목 리스트",
        example = """
            [
                {
                    "SONG_ID": "32908826",
                    "SONG_NAME": "Criminal",
                    "ARTIST_NAME": "태민(TAEMIN)",
                    "ALBUM_NAME": "Never Gonna Dance Again : Act 1 - The 3rd Album",
                    "ALBUM_IMG_PATH": "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/563/195/81563195_1599461944004_1_600x600.JPG/dims/resize/Q_80,0",
                    "RANK_NO": 1,
                    "PRE_RANK_NO": 2,
                    "TOP_RANK_NO": 1
                }
            ]
        """
    )
    @JsonProperty("DATA")
    @ArraySchema(schema = Schema(implementation = GenieChartItem::class))
    val data: List<GenieChartItem>
)