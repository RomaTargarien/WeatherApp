package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.weather_modules.Hour
import com.example.weatherapp.util.returnImageResourse
import kotlinx.android.synthetic.main.item_hour_weather.view.*

class TodayWeatherAdapter(val hours: List<Hour>) : RecyclerView.Adapter<TodayWeatherAdapter.TodayWeatherViewHolder>() {

    class TodayWeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(hour: Hour) {
            itemView.tvHour.text = hour.hour
            itemView.tvHourDegree.text = hour.temp.toString()
            itemView.ivWeather.setImageResource(returnImageResourse(hour))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hour_weather,parent,false)
        return TodayWeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodayWeatherViewHolder, position: Int) {
        holder.bind(hours[position])
    }

    override fun getItemCount() = hours.size


}