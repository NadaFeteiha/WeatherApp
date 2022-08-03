package com.nadafeteiha.weatherapp.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


fun String.stringToDate(): LocalDate =
    LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

fun String.stringToDateHour(): String {
    var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    val date = sdf.parse(this)
    sdf = SimpleDateFormat("hhaa")
    return sdf.format(date)
}
