package com.example.weatherapp.main

import com.example.weatherapp.data.CountryApi
import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.data.country_modules.Country
import com.example.weatherapp.data.weather_modules.Weather
import com.example.weatherapp.util.Resourse
import java.lang.Exception
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val countryApi: CountryApi,
    private val weatherApi: WeatherApi
) :IMainRepository {

    override suspend fun getWeatherData(latitude: String, longitude: String): Resourse<Weather> {
        return  try {
            val response = weatherApi.getWeatherData(latitude,longitude)
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resourse.Success(result)
            } else {
                Resourse.Error(response.message())
            }
        } catch (e: Exception){
            Resourse.Error(e.message ?: "An error")
        }
    }

    override suspend fun getCountry(country: String): Resourse<Country> {
        return  try {
            val response = countryApi.getCountry(country)
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resourse.Success(result)
            } else {
                Resourse.Error(response.message())
            }
        } catch (e: Exception){
            Resourse.Error(e.message ?: "An error")
        }
    }
}