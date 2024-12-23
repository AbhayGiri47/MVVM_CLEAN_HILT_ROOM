package com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter

import androidx.room.TypeConverter
import com.example.mvvmcleanhiltroom.data.response.Venue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class VenueConverter {

    private val gson = Gson()

    @TypeConverter
    fun toVenue(value: String?): Venue? {
        return if (value.isNullOrEmpty()) {
            null
        } else {
            val type = object : TypeToken<Venue>() {}.type
            gson.fromJson(value, type)
        }
    }

    @TypeConverter
    fun fromVenue(value: Venue?): String? {
        return gson.toJson(value)
    }
}