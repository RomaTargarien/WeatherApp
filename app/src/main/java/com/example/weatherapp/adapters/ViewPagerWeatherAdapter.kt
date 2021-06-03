package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.weather_modules.Weather
import kotlinx.android.synthetic.main.item_weather.view.*

class ViewPagerWeatherAdapter(val list: List<Weather>) :
    RecyclerView.Adapter<ViewPagerWeatherAdapter.ViewPageHolder>() {

    inner class ViewPageHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(weather: Weather) {
            itemView.tvTown.text = weather.info.tzinfo.name
            itemView.tvDegree.text = weather.fact.temp.toString()
            itemView.tvWeather.text = weather.fact.condition
            itemView.tvMinMax.text = "max - ${weather.forecasts[0].parts.day_short.temp}," +
                    " min - ${weather.forecasts[0].parts.night.temp_min}"
            itemView.rvToday.layoutManager =
                LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
            itemView.rvToday.adapter = TodayWeatherAdapter(weather.forecasts[0].hours)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent,false)
        return ViewPageHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPageHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}