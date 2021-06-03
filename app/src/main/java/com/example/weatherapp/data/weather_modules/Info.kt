package com.example.weatherapp.data.weather_modules

data class Info(
    val def_pressure_mm: Double,
    val def_pressure_pa: Double,
    val lat: Double,
    val lon: Double,
    val tzinfo: Tzinfo,
    val url: String
)