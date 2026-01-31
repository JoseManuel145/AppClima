package com.manu.weathercontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.manu.weathercontrol.core.di.AppContainer
import com.manu.weathercontrol.core.providers.LocationProvider
import com.manu.weathercontrol.core.ui.theme.WeatherControlTheme
import com.manu.weathercontrol.features.weather.di.WeatherModule
import com.manu.weathercontrol.features.weather.presentation.screens.MainScreen

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer
    lateinit var locationProvider: LocationProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        appContainer = AppContainer(this)
        locationProvider = LocationProvider(this)
        val weatherModule = WeatherModule(appContainer, locationProvider)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherControlTheme {
                MainScreen(weatherModule.provideWeatherViewModelFactory())
            }
        }
    }
}
