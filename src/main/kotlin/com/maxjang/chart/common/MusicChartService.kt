package com.maxjang.chart.common

interface MusicChartService {
    fun fetchRealTimeChart(): List<MusicChartItem>
}
