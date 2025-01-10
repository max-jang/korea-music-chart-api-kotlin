package com.maxjang.chart.common

/**
 * 차트 API 엔드포인트
 */
object ChartApiEndpoints {
    const val GENIE_REALTIME_URL = "https://app.genie.co.kr/chart/j_RealTimeRankSongList.json?pg=1&pgsize=100"
    const val MELON_REALTIME_URL = "https://m2.melon.com/m6/chart/ent/songChartList.json"
    const val VIBE_REALTIME_URL = "https://apis.naver.com/vibeWeb/musicapiweb/vibe/v1/chart/track/total?start=1&display=100"
    const val BUGS_REALTIME_URL = "https://m.bugs.co.kr/api/getChartTrack"
}