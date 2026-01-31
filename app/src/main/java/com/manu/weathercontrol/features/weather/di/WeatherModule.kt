package com.manu.weathercontrol.features.weather.di

import com.manu.weathercontrol.core.di.AppContainer
import com.manu.weathercontrol.core.providers.LocationProvider
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherRecommendationsUseCase
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherUseCase
import com.manu.weathercontrol.features.weather.presentation.viewmodels.WeatherViewModelFactory

class WeatherModule(
    private val appContainer: AppContainer,
    private val locationProvider: LocationProvider
) {
    private fun provideGetWeatherUseCase(): GetWeatherUseCase {
        return GetWeatherUseCase(appContainer.weatherRepository)
    }
    private fun provideGetWeatherRecommendationsUseCase(): GetWeatherRecommendationsUseCase {
        return GetWeatherRecommendationsUseCase()
    }

    fun provideWeatherViewModelFactory(): WeatherViewModelFactory {
        return WeatherViewModelFactory(
            getWeatherUseCase = provideGetWeatherUseCase(),
            getWeatherRecommendationsUseCase = provideGetWeatherRecommendationsUseCase(),
            locationProvider = locationProvider
        )
    }

}
