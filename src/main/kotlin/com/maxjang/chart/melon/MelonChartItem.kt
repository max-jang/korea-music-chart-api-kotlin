package com.maxjang.chart.melon

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "멜론 차트 항목 데이터 모델")
data class MelonChartItem(
    @JsonProperty("SONGID")
    @Schema(description = "곡 고유 번호", example = "32908826")
    val songId: String,

    @JsonProperty("SONGNAME")
    @Schema(description = "곡명", example = "Criminal")
    val songName: String,

    @JsonProperty("ARTISTLIST")
    @Schema(description = "아티스트 이름", example = "태민(TAEMIN)")
    val artistList: List<MelonArtist>,

    @JsonProperty("ALBUMNAME")
    @Schema(description = "앨범명", example = "Never Gonna Dance Again : Act 1 - The 3rd Album")
    val albumName: String,

    @JsonProperty("ALBUMIMGPATH")
    @Schema(
        description = "앨범 이미지 URL",
        example = "https://cdnimg.melon.co.kr/cm2/album/images/104/86/847/10486847_20200907155042_500.jpg"
    )
    val albumImgPath: String,

    @JsonProperty("CURRANK")
    @Schema(description = "현재 순위", example = "1")
    val currRank: Int,

    @JsonProperty("PASTRANK")
    @Schema(description = "이전 순위", example = "2")
    val pastRank: Int,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "아티스트 정보")
data class MelonArtist(
    @JsonProperty("ARTISTNAME")
    @Schema(description = "아티스트 이름", example = "태민(TAEMIN)")
    val artistName: String
)