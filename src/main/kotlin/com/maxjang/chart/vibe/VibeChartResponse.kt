package com.maxjang.chart.vibe

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 바이브 차트 API 응답 데이터 모델
 */
@Schema(description = "바이브 차트 API 응답 데이터 모델")
@JsonIgnoreProperties(ignoreUnknown = true)
data class VibeChartResponse(
    @Schema(description = "응답 데이터")
    @JsonProperty("response")
    val response: Response
) {
    /**
     * 응답 내부 데이터 모델
     */
    @Schema(description = "응답 내부 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Response(
        @Schema(description = "결과 데이터")
        @JsonProperty("result")
        val result: Result
    )

    /**
     * 결과 데이터 모델
     */
    @Schema(description = "결과 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Result(
        @Schema(description = "차트 데이터")
        @JsonProperty("chart")
        val chart: Chart
    )

    /**
     * 차트 데이터 모델
     */
    @Schema(description = "차트 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Chart(
        @Schema(description = "차트 항목 데이터")
        @JsonProperty("items")
        val items: Items
    )

    /**
     * 차트 항목 데이터 모델
     */
    @Schema(description = "차트 항목 리스트")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Items(
        @ArraySchema(schema = Schema(implementation = Track::class))
        @JsonProperty("tracks")
        val tracks: List<Track>
    )

    /**
     * 트랙 데이터 모델
     */
    @Schema(description = "트랙 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Track(
        @Schema(description = "트랙 ID", example = "87518567")
        @JsonProperty("trackId")
        val trackId: Long,

        @Schema(description = "트랙 제목", example = "APT.")
        @JsonProperty("trackTitle")
        val trackTitle: String,

        @Schema(description = "아티스트 리스트")
        @JsonProperty("artists")
        @ArraySchema(schema = Schema(implementation = Artist::class))
        val artists: List<Artist>,

        @Schema(description = "앨범 정보")
        @JsonProperty("album")
        val album: Album,

        @Schema(description = "순위 정보")
        @JsonProperty("rank")
        val rank: Rank
    )

    /**
     * 아티스트 데이터 모델
     */
    @Schema(description = "아티스트 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Artist(
        @Schema(description = "아티스트 이름", example = "로제 (ROSÉ)")
        @JsonProperty("artistName")
        val artistName: String
    )

    /**
     * 앨범 데이터 모델
     */
    @Schema(description = "앨범 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Album(
        @Schema(description = "앨범 제목", example = "APT.")
        @JsonProperty("albumTitle")
        val albumTitle: String,

        @Schema(
            description = "앨범 이미지 URL",
            example = "https://musicmeta-phinf.pstatic.net/album/032/218/32218786.jpg"
        )
        @JsonProperty("imageUrl")
        val imageUrl: String
    )

    /**
     * 순위 데이터 모델
     */
    @Schema(description = "순위 데이터")
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Rank(
        @Schema(description = "현재 순위", example = "1")
        @JsonProperty("currentRank")
        val currentRank: Int,

        @Schema(description = "순위 변동", example = "-1")
        @JsonProperty("rankVariation")
        val rankVariation: Int
    )
}
