package com.example.weatherapp.data.weather_modules

data class Weather(
    val fact: Fact,
    val forecasts: List<Forecast>,
    val info: Info,
    val now: Int,
    val now_dt: String
)