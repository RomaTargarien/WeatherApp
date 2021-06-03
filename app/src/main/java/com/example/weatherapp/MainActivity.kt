package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.weatherapp.adapters.ViewPagerWeatherAdapter
import com.example.weatherapp.data.weather_modules.Weather
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var list = MutableLiveData<MutableList<Weather>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        mainViewModel.getWeather("berlin")
        val listofweather = mutableListOf<Weather>()
        mainViewModel.weather.observe(this, Observer {
            listofweather.add(it)
            list.postValue(listofweather)
        })

        list.observe(this, Observer {
            val adapter = ViewPagerWeatherAdapter(it.toList())
            binding.vpWeather.adapter = adapter
        })
    }
}