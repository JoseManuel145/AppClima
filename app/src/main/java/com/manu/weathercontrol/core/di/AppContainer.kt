package com.manu.weathercontrol.core.di

import android.content.Context
import com.manu.weathercontrol.core.network.WeatherApi
import com.manu.weathercontrol.features.weather.data.repositories.WeatherRepositoryImpl
import com.manu.weathercontrol.features.weather.domain.repositories.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherApi: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }

    val weatherRepository: WeatherRepository by lazy {
        WeatherRepositoryImpl(weatherApi)
    }
}