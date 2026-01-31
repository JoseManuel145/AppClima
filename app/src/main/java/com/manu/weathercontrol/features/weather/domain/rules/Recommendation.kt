package com.manu.weathercontrol.features.weather.domain.rules

data class Recommendation(
    val code: RecommendationCode,
    val type: RecommendationType,
    val message: String
)
