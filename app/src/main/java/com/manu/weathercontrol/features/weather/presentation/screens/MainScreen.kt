package com.manu.weathercontrol.features.weather.presentation.screens

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manu.weathercontrol.features.weather.presentation.components.TabItem
import com.manu.weathercontrol.features.weather.presentation.viewmodels.WeatherViewModelFactory
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.manu.weathercontrol.features.weather.presentation.viewmodels.WeatherViewModel
import android.Manifest

@Composable
fun MainScreen(factory: WeatherViewModelFactory) {
    val viewModel: WeatherViewModel = viewModel(factory = factory)

    val navController = rememberNavController()
    val tabs = listOf(
        TabItem.Clima,
        TabItem.Ropa,
        TabItem.Comida,
        TabItem.Actividad,
        TabItem.Seguridad
    )
    val context = LocalContext.current

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            val granted = permissions.values.all { it }
            if (granted) {
                viewModel.loadWeatherWithGps()
            }
        }

    LaunchedEffect(Unit) {
        val hasPermission =
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            viewModel.loadWeatherWithGps()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute =
                    navController.currentBackStackEntryAsState().value
                        ?.destination?.route

                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = null) },
                        label = { Text(tab.title) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = TabItem.Clima.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(TabItem.Clima.route) {
                WeatherOverviewScreen(viewModel = viewModel)
            }
            composable(TabItem.Ropa.route) {
                ClothingRecommendationsScreen(viewModel = viewModel)
            }
            composable(TabItem.Comida.route) {
                FoodRecommendationsScreen(viewModel = viewModel)
            }
            composable(TabItem.Actividad.route) {
                HealthRecommendationsScreen(viewModel = viewModel)
            }
            composable(TabItem.Seguridad.route) {
                SafetyRecommendationsScreen(viewModel = viewModel)
            }
        }
    }
}
