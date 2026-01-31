package com.manu.weathercontrol.features.weather.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Clima : TabItem("clima", "Clima", Icons.Default.Home)
    object Ropa : TabItem("ropa", "Ropa", Icons.Default.Info)
    object Comida : TabItem("comida", "Comida", Icons.Default.Info)
    object Actividad : TabItem("actividad", "Actividad", Icons.Default.Info)
    object Seguridad : TabItem("seguridad", "Seguridad", Icons.Default.Info)
}
