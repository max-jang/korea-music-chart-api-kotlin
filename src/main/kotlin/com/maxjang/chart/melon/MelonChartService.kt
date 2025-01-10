package com.maxjang.chart.melon

import com.fasterxml.jackson.databind.ObjectMapper
import com.maxjang.chart.common.ChartApiEndpoints.MELON_REALTIME_URL
import com.maxjang.chart.common.MusicChartItem
import com.maxjang.chart.common.MusicChartService
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/**
 * 멜론 차트 API를 호출하여 실시간 차트를 가져오는 서비스
 * @property restTemplate RestTemplate
 * @property objectMapper ObjectMapper
 * @constructor
 */
@Service
class MelonChartService(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) : MusicChartService {
    // 실시간 차트를 가져와 MusicChartItem 리스트로 변환하는 메소드
    override fun fetchRealTimeChart(): List<MusicChartItem> {
        // API로부터 JSON 데이터 가져오기
        val response: String = restTemplate.getForObject(MELON_REALTIME_URL, String::class.java)
            ?: throw RuntimeException("No response from Melon API")

        // JSON 데이터를 MelonChartResponse 객체로 변환
        val chartResponse: MelonChartResponse = objectMapper.readValue(response, MelonChartResponse::class.java)

        // 데이터셋에서 각 곡 정보를 MusicChartItem으로 변환
        return chartResponse.response.songList.map { item ->
            MusicChartItem(
                artistName = URLDecoder.decode(
                    item.artistList.firstOrNull()?.artistName ?: "Unknown Artist",
                    StandardCharsets.UTF_8.name()
                ),
                albumName = URLDecoder.decode(item.albumName, StandardCharsets.UTF_8.name()),
                songName = URLDecoder.decode(item.songName, StandardCharsets.UTF_8.name()),
                albumImageUrl = URLDecoder.decode(item.albumImgPath, StandardCharsets.UTF_8.name()),
                songUniqueId = item.songId,
                currentRank = item.currRank,
                previousRank = item.pastRank
            )
        }
    }
}
