package com.example.weatherapp.data.weather_modules

data class Night(
    val cloudness: Double,
    val condition: String,
    val daytime: String,
    val feels_like: Double,
    val humidity: Double,
    val icon: String,
    val polar: Boolean,
    val prec_mm: Double,
    val prec_period: Double,
    val prec_strength: Double,
    val prec_type: Double,
    val pressure_mm: Double,
    val pressure_pa: Double,
    val temp_avg: Double,
    val temp_max: Double,
    val temp_min: Double,
    val wind_dir: String,
    val wind_gust: Double,
    val wind_speed: Double
)