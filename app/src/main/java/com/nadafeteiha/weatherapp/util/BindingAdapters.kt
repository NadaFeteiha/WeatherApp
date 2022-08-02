package com.nadafeteiha.weatherapp.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.nadafeteiha.weatherapp.R
import com.squareup.picasso.Picasso


@BindingAdapter("weatherIcon")
fun bindWeatherIcon(icon: ImageView, iconCode: String) {
    iconCode.let {
        val imgURL = Constants.IMAGE_URL + iconCode + ".png"
        val imgUri = imgURL.toUri().buildUpon().scheme("https").build()
        Picasso.get()
            .load(imgUri)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.icon_weather)
            .into(icon)
    }
}

@BindingAdapter("day")
fun bindTextDay(textDay: TextView, date: String) {
    date.let {
        textDay.text = date.stringToDate().dayOfWeek.name
    }
}

@BindingAdapter("hour")
fun bindTextHour(textDay: TextView, date: String) {
    date.let {
        textDay.text = date.stringToDateHour().removePrefix("0")
    }
}