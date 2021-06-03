package com.example.weatherapp.data

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.weather_modules.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers("X-Yandex-API-Key: ${BuildConfig.WEATHER_API_KEY}")
    @GET("forecast?extra=true")
    suspend fun getWeatherData (
        @Query("lat") lat: String ="52.5170365",
        @Query("lon") lon: String = "13.3888599"
    ): Response<Weather>

}