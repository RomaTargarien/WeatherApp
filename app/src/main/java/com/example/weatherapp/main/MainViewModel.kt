package com.example.weatherapp.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.weather_modules.Weather
import com.example.weatherapp.main.IMainRepository
import com.example.weatherapp.util.Resourse
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(val repository: IMainRepository) : ViewModel() {

    var weather = MutableLiveData<Weather>()
    var errorMessageCountry: String = ""
    var errorMessageWeather: String = ""

    fun getWeather(country: String) = viewModelScope.launch {
        val responseCountry = repository.getCountry(country)
        when (responseCountry) {
            is Resourse.Success -> {
                val lat = responseCountry.data!!.hits[0].point.lat.toString()
                val lon = responseCountry.data.hits[0].point.lng.toString()
                getWeatherOfTheCountry(lat,lon)
            }
            is Resourse.Error -> errorMessageCountry = "Can't find this country"

        }
    }
    fun getWeatherOfTheCountry(lat: String, lon: String) = viewModelScope.launch {
        val responseWeather = repository.getWeatherData(lat,lon)
        when (responseWeather) {
            is Resourse.Success -> weather.postValue(responseWeather.data)
            is Resourse.Error -> errorMessageWeather = responseWeather.message!!
        }
    }
}