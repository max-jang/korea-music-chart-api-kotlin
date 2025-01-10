package com.maxjang.chart.genie

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema

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
                    "ALBUM_IMG_PATH": "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg",
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
