package com.maxjang.chart.common

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "음악 차트 항목")
data class MusicChartItem(
    @Schema(description = "아티스트 이름", example = "태민(TAEMIN)")
    val artistName: String,

    @Schema(description = "앨범명", example = "Never Gonna Dance Again : Act 1 - The 3rd Album")
    val albumName: String,

    @Schema(description = "곡명", example = "Criminal")
    val songName: String,

    @Schema(
        description = "앨범 이미지 URL",
        example = "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg"
    )
    val albumImageUrl: String,

    @Schema(description = "곡 고유 번호", example = "32908826")
    val songUniqueId: String,

    @Schema(description = "현재 순위", example = "1")
    val currentRank: Int,

    @Schema(description = "이전 차트 순위", example = "1")
    val previousRank: Int,
)
