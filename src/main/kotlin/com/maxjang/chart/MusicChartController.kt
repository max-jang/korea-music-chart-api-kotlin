package com.maxjang.chart

import com.maxjang.chart.common.MusicChartResponse
import com.maxjang.chart.common.MusicChartService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Korea Music Chart API", description = "한국 실시간 TOP 100 음악 차트를 조회하는 API")
@RestController
@RequestMapping("/api/chart")
class MusicChartController(
    private val chartServices: Map<String, MusicChartService>
) {
    @Operation(
        summary = "실시간 차트 조회",
        description = "지정된 제공자(provider)의 실시간 차트를 반환합니다."
    )
    @GetMapping("/{provider}/realtime")
    fun getRealTimeChart(
        @Parameter(
            description = "음악 차트를 제공하는 제공자 (예: genie, melon, vibe, bugs)",
            example = "genie"
        )
        @PathVariable provider: String
    ): ResponseEntity<MusicChartResponse<Any>> {
        // 주입된 서비스에서 요청된 제공자(provider)의 서비스 찾기
        val chartService = chartServices["${provider}ChartService"]
            ?: return ResponseEntity(
                MusicChartResponse(code = 404, status = "Not Found", data = "올바르지 않는 제공자 입니다."),
                HttpStatus.NOT_FOUND
            )

        return try {
            // 해당 서비스의 실시간 차트 반환
            val chartData = chartService.fetchRealTimeChart()

            ResponseEntity(
                MusicChartResponse(
                    code = 200,
                    status = "OK",
                    data = chartData
                ),
                HttpStatus.OK
            )
        } catch (e: Exception) { // 에러 발생 시 예외 처리
            e.printStackTrace()
            ResponseEntity(
                MusicChartResponse(
                    code = 500,
                    status = "Internal Server Error",
                    data = "차트를 가져오는 중 문제가 발생했습니다."
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}
