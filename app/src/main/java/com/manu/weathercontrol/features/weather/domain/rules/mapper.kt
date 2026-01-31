package com.manu.weathercontrol.features.weather.domain.rules

fun RecommendationCode.toRecommendation(): Recommendation {
    return when (this) {
        RecommendationCode.USE_JACKET ->
            Recommendation(this, RecommendationType.CLOTHING, "Usar chamarra ligera")

        RecommendationCode.USE_COAT ->
            Recommendation(this, RecommendationType.CLOTHING, "Usar abrigo")

        RecommendationCode.WEAR_THERMAL_CLOTHING ->
            Recommendation(this, RecommendationType.CLOTHING, "Ropa térmica")

        RecommendationCode.WEAR_LIGHT_CLOTHING ->
            Recommendation(this, RecommendationType.CLOTHING, "Ropa ligera")

        RecommendationCode.WEAR_WATERPROOF_CLOTHING ->
            Recommendation(this, RecommendationType.CLOTHING, "Ropa impermeable")

        RecommendationCode.EAT_WARM_MEALS ->
            Recommendation(this, RecommendationType.FOOD, "Comidas calientes")

        RecommendationCode.EAT_LIGHT_MEALS ->
            Recommendation(this, RecommendationType.FOOD, "Comidas ligeras")

        RecommendationCode.AVOID_HEAVY_MEALS ->
            Recommendation(this, RecommendationType.FOOD, "Evitar comidas pesadas")

        RecommendationCode.AVOID_COLD_DRINKS ->
            Recommendation(this, RecommendationType.FOOD, "Evitar bebidas frías")

        RecommendationCode.STAY_HYDRATED ->
            Recommendation(this, RecommendationType.HEALTH, "Mantenerse hidratado")

        RecommendationCode.USE_SUNSCREEN ->
            Recommendation(this, RecommendationType.HEALTH, "Usar bloqueador solar")

        RecommendationCode.AVOID_SUN_EXPOSURE ->
            Recommendation(this, RecommendationType.HEALTH, "Evitar exposición al sol")

        RecommendationCode.USE_UMBRELLA ->
            Recommendation(this, RecommendationType.SAFETY, "Usar paraguas")

        RecommendationCode.SECURE_OBJECTS ->
            Recommendation(this, RecommendationType.SAFETY, "Asegurar objetos sueltos")

        RecommendationCode.AVOID_HIGH_PLACES ->
            Recommendation(this, RecommendationType.SAFETY, "Evitar lugares altos")

        RecommendationCode.AVOID_OUTDOORS ->
            Recommendation(this, RecommendationType.SAFETY, "Evitar actividades al aire libre")

        RecommendationCode.USE_HAT ->
            Recommendation(this, RecommendationType.CLOTHING, "Usar gorra o sombrero")

        RecommendationCode.WEAR_SUN_GLASSES ->
            Recommendation(this, RecommendationType.CLOTHING, "Usar lentes de sol")
    }
}
