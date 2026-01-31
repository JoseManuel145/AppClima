package com.manu.weathercontrol.features.weather.domain.usecases

import com.manu.weathercontrol.features.weather.domain.entities.Weather
import com.manu.weathercontrol.features.weather.domain.rules.Recommendation
import com.manu.weathercontrol.features.weather.domain.rules.generateRecommendations

class GetWeatherRecommendationsUseCase {

    operator fun invoke(weather: Weather): List<Recommendation> {
        return generateRecommendations(weather)
    }
}
