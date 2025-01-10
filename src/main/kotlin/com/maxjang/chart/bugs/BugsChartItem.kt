package com.maxjang.chart.bugs

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "벅스 차트 항목 데이터 모델")
data class BugsChartItem(
    @Schema(description = "곡명", example = "toxic till the end")
    val songTitle: String,

    @Schema(description = "아티스트 이름", example = "로제(ROSÉ)")
    val artistName: String,

    @Schema(description = "앨범명", example = "rosie")
    val albumName: String,

    @Schema(
        description = "앨범 이미지 URL",
        example = "https://music.bugs.co.kr/album/41113/4111311.jpg"
    )
    val albumImageUrl: String,

    @Schema(description = "현재 순위", example = "1")
    val rank: Int
)
