package com.manu.weathercontrol.features.weather.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.manu.weathercontrol.features.weather.domain.rules.RecommendationType
import com.manu.weathercontrol.features.weather.presentation.components.CenterMessage
import com.manu.weathercontrol.features.weather.presentation.components.RecommendationCard
import com.manu.weathercontrol.features.weather.presentation.viewmodels.WeatherViewModel

@Composable
fun SafetyRecommendationsScreen(
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> {
            CenterMessage("Cargando recomendaciones...")
        }

        uiState.recommendationCodes.isEmpty() -> {
            CenterMessage("No hay recomendaciones")
        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Seguridad recomendada",
                    style = MaterialTheme.typography.headlineMedium
                )

                uiState.recommendationCodes
                    .filter { it.type == RecommendationType.SAFETY }
                    .forEach { item ->
                        RecommendationCard(
                            title = item.message
                        )
                    }
            }
        }
    }
}
