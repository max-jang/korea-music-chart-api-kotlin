package com.maxjang.chart.bugs

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 벅스 차트 API 응답 데이터 모델
 */
@Schema(description = "벅스 차트 API 응답 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsChartResponse(
    @Schema(
        description = "트랙 리스트",
        example = """
            [
                {
                    "track_title": "toxic till the end",
                    "track_id": "6274999",
                    "artists": [
                        {
                            "artist_nm": "로제(ROSÉ)"
                        },
                        {
                            "artist_nm": "Bruno Mars(브루노 마스)"
                        }
                    ],
                    "album": {
                        "title": "rosie",
                        "image": {
                            "path": "/41113/4111311.jpg"
                        }
                    },
                    "list_attr": {
                        "rank": 1,
                        "rank_last": 2
                    }
                }
            ]
        """
    )
    @JsonProperty("list")
    @ArraySchema(schema = Schema(implementation = BugsTrackItem::class))
    val tracks: List<BugsTrackItem>
)

/**
 * 벅스 트랙 데이터 모델
 */
@Schema(description = "벅스 차트 트랙 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsTrackItem(
    @Schema(description = "곡 제목", example = "toxic till the end")
    @JsonProperty("track_title")
    val songTitle: String,

    @Schema(description = "곡 ID", example = "6274999")
    @JsonProperty("track_id")
    val songId: String,

    @Schema(description = "아티스트 정보 리스트")
    @JsonProperty("artists")
    @ArraySchema(schema = Schema(implementation = BugsArtistItem::class))
    val artists: List<BugsArtistItem>,

    @Schema(description = "앨범 정보")
    @JsonProperty("album")
    val album: BugsAlbumItem,

    @Schema(description = "순위 정보")
    @JsonProperty("list_attr")
    val rankInfo: BugsRankItem
)

/**
 * 벅스 아티스트 데이터 모델
 */
@Schema(description = "벅스 차트 아티스트 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsArtistItem(
    @Schema(description = "아티스트 이름", example = "로제(ROSÉ)")
    @JsonProperty("artist_nm")
    val artistName: String
)

/**
 * 벅스 앨범 데이터 모델
 */
@Schema(description = "벅스 차트 앨범 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsAlbumItem(
    @Schema(description = "앨범 제목", example = "rosie")
    @JsonProperty("title")
    val albumName: String,

    @Schema(
        description = "앨범 이미지 정보",
        example = """
            {
                "path": "/41113/4111311.jpg"
            }
        """
    )
    @JsonProperty("image")
    val image: BugsImageItem
)

/**
 * 벅스 이미지 데이터 모델
 */
@Schema(description = "벅스 차트 이미지 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsImageItem(
    @Schema(description = "이미지 경로", example = "/41113/4111311.jpg")
    @JsonProperty("path")
    val imagePath: String
)

/**
 * 벅스 순위 데이터 모델
 */
@Schema(description = "벅스 차트 순위 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class BugsRankItem(
    @Schema(description = "현재 순위", example = "1")
    @JsonProperty("rank")
    val rank: Int,

    @Schema(description = "이전 순위", example = "2")
    @JsonProperty("rank_last")
    val rankLast: Int
)