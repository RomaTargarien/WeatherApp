package com.example.weatherapp.data.weather_modules

data class Tzinfo(
    val abbr: String,
    val dst: Boolean,
    val name: String,
    val offset: Double
)