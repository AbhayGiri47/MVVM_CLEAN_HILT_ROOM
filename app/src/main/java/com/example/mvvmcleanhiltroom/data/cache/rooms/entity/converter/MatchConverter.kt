package com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter

import androidx.room.TypeConverter
import com.example.mvvmcleanhiltroom.data.response.Match
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MatchConverter {

    private val gson = Gson()

    @TypeConverter
    fun toMatch(value: String?): Match? {
        return if (value.isNullOrEmpty()) {
            null
        } else {
            val type = object : TypeToken<Match>() {}.type
            gson.fromJson(value, type)
        }
    }

    @TypeConverter
    fun fromMatch(value: Match?): String? {
        return gson.toJson(value)
    }
}