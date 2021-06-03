package com.example.weatherapp.main

import com.example.weatherapp.data.country_modules.Country
import com.example.weatherapp.data.weather_modules.Weather
import com.example.weatherapp.util.Resourse

interface IMainRepository {
    suspend fun getWeatherData(latitude: String,longitude:String) : Resourse<Weather>
    suspend fun getCountry(country: String) : Resourse<Country>
}