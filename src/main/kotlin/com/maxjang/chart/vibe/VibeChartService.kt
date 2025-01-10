package com.maxjang.chart.vibe

import com.fasterxml.jackson.databind.ObjectMapper
import com.maxjang.chart.common.ChartApiEndpoints.VIBE_REALTIME_URL
import com.maxjang.chart.common.MusicChartItem
import com.maxjang.chart.common.MusicChartService
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * 바이브 차트 API를 호출하여 실시간 차트를 가져오는 서비스
 * @property restTemplate RestTemplate
 * @property xmlMapper XmlMapper
 * @constructor
 */

@Service
class VibeChartService(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) : MusicChartService {
    override fun fetchRealTimeChart(): List<MusicChartItem> {
        // API로부터 JSON 데이터 가져오기
        val response: String = restTemplate.getForObject(VIBE_REALTIME_URL, String::class.java)
            ?: throw RuntimeException("No response from VIBE API")

        // JSON 데이터를 VibeChartResponse 객체로 변환
        val chartResponse: VibeChartResponse = objectMapper.readValue(response, VibeChartResponse::class.java)

        // 데이터셋에서 각 곡 정보를 MusicChartItem으로 변환
        return chartResponse.response.result.chart.items.tracks.map { track ->
            MusicChartItem(
                artistName = track.artists.joinToString(", ") { it.artistName },
                albumName = track.album.albumTitle,
                songName = track.trackTitle,
                albumImageUrl = track.album.imageUrl,
                songUniqueId = track.trackId.toString(),
                currentRank = track.rank.currentRank,
                previousRank = track.rank.currentRank - track.rank.rankVariation
            )
        }
    }
}

