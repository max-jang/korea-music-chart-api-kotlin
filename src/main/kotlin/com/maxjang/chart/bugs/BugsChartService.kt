package com.maxjang.chart.bugs

import com.fasterxml.jackson.databind.ObjectMapper
import com.maxjang.chart.common.ChartApiEndpoints.BUGS_REALTIME_URL
import com.maxjang.chart.common.MusicChartItem
import com.maxjang.chart.common.MusicChartService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class BugsChartService(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) : MusicChartService {

    override fun fetchRealTimeChart(): List<MusicChartItem> {
        // 폼 데이터 생성
        val formData = mapOf(
            "meta_type" to "track",
            "period_tp" to "realtime",
            "svc_type" to "20151",
            "size" to "100"
        )

        // HTTP 헤더 설정
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }

        // 요청 엔티티 생성
        val entity = HttpEntity(formData.map { "${it.key}=${it.value}" }.joinToString("&"), headers)

        // API 호출
        val response: String = restTemplate.exchange(
            BUGS_REALTIME_URL,
            HttpMethod.POST,
            entity,
            String::class.java
        ).body ?: throw RuntimeException("No response from Bugs API")

        // JSON 파싱
        val chartResponse: BugsChartResponse = objectMapper.readValue(response, BugsChartResponse::class.java)

        // 데이터 변환
        return chartResponse.tracks.map { track ->
            MusicChartItem(
                songName = track.songTitle,
                artistName = track.artists.joinToString(", ") { it.artistName },
                albumName = track.album.albumName,
                albumImageUrl = "https://image.bugsm.co.kr/album/images/350${track.album.image.imagePath}",
                songUniqueId = track.songId,
                currentRank = track.rankInfo.rank,
                previousRank = track.rankInfo.rankLast
            )
        }
    }
}
