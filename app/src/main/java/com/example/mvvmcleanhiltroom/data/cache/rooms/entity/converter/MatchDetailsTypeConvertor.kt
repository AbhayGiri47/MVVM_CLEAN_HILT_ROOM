package com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter

import androidx.room.TypeConverter
import com.example.mvvmcleanhiltroom.data.response.MatchDetail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MatchDetailsTypeConvertor {

    private val gson = Gson()

    @TypeConverter
    fun toMatchDetails(value: String?): MatchDetail? {
        return if (value.isNullOrEmpty()) {
            null
        } else {
            val type = object : TypeToken<MatchDetail>() {}.type
            gson.fromJson(value, type)
        }
    }

    @TypeConverter
    fun fromMatchDetails(value: MatchDetail?): String? {
        return gson.toJson(value)
    }
}