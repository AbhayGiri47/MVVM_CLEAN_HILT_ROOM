package com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter

import androidx.room.TypeConverter
import com.example.mvvmcleanhiltroom.data.response.Series
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SeriesConverter {

    private val gson = Gson()

    @TypeConverter
    fun toSeriesDetails(value: String?): Series? {
        return if (value.isNullOrEmpty()) {
            null
        } else {
            val type = object : TypeToken<Series>() {}.type
            gson.fromJson(value, type)
        }
    }

    @TypeConverter
    fun fromSeries(value: Series?): String? {
        return gson.toJson(value)
    }
}