package com.maxjang.chart.genie

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "지니뮤직 차트 항목 데이터 모델")
data class GenieChartItem(

    @JsonProperty("SONG_ID")
    @Schema(description = "곡 고유 번호", example = "32908826")
    val songId: String,

    @JsonProperty("SONG_NAME")
    @Schema(description = "곡명", example = "Criminal")
    val songName: String,

    @JsonProperty("ARTIST_NAME")
    @Schema(description = "아티스트 이름", example = "태민(TAEMIN)")
    val artistName: String,

    @JsonProperty("ALBUM_NAME")
    @Schema(description = "앨범명", example = "Never Gonna Dance Again : Act 1 - The 3rd Album")
    val albumName: String,

    @JsonProperty("ALBUM_IMG_PATH")
    @Schema(
        description = "앨범 이미지 URL",
        example = "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg"
    )
    val albumImgPath: String,

    @JsonProperty("RANK_NO")
    @Schema(description = "현재 순위", example = "1")
    val rankNo: Int,

    @JsonProperty("PRE_RANK_NO")
    @Schema(description = "이전 순위", example = "2")
    val preRankNo: Int,

    @JsonProperty("TOP_RANK_NO")
    @Schema(description = "최고 순위", example = "1")
    val topRankNo: Int
)
