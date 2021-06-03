package com.example.weatherapp.data.weather_modules

data class Forecast(
    val date: String,
    val date_ts: Double,
    val hours: List<Hour>,
    val moon_code: Double,
    val moon_text: String,
    val parts: Parts,
    val sunrise: String,
    val sunset: String,
    val week: Double
)