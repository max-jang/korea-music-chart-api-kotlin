package com.maxjang.chart

import com.maxjang.chart.common.CommonResponse
import com.maxjang.chart.common.MusicChartItem
import com.maxjang.chart.common.MusicChartService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.swagger.v3.oas.annotations.responses.ApiResponse as SwaggerApiResponse

@Tag(name = "Korea Music Chart API", description = "한국 실시간 음악 차트을 조회하는 API")
@RestController
@RequestMapping("/api/chart")
class ChartController(
    private val chartServices: Map<String, MusicChartService>
) {
    @Operation(
        summary = "실시간 차트 조회",
        description = "지정된 제공자(provider)의 실시간 차트를 반환합니다.",
        responses = [
            SwaggerApiResponse(
                responseCode = "200",
                description = "성공적으로 차트를 반환합니다.",
                content = [io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = CommonResponse::class)
                )]
            ),
            SwaggerApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
            SwaggerApiResponse(responseCode = "404", description = "지원하지 않는 제공자입니다.")
        ]
    )
    @GetMapping("/{provider}/realtime")
    fun getRealTimeChart(
        @Parameter(
            description = "음악 차트를 제공하는 제공자 (예: genie, melon)",
            example = "genie"
        )
        @PathVariable provider: String
    ): CommonResponse<List<MusicChartItem>> {
        // 주입된 서비스에서 요청된 제공자(provider)의 서비스 찾기
        val chartService = chartServices["${provider}ChartService"]
            ?: throw IllegalArgumentException("Unsupported chart provider: $provider")

        // 해당 서비스의 실시간 차트 반환
        val chartData = chartService.fetchRealTimeChart()

        return CommonResponse(
            code = 200,
            status = "OK",
            data = chartData
        )
    }
}
