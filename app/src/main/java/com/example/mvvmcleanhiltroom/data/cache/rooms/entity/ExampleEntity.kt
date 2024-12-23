package com.example.mvvmcleanhiltroom.data.cache.rooms.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter.MatchConverter
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter.MatchDetailsTypeConvertor
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter.SeriesConverter
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.converter.VenueConverter
import com.example.mvvmcleanhiltroom.data.cache.utils.RoomConstants.TABLE_EXAMPLE
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.MatchDetail

@Entity(tableName = TABLE_EXAMPLE)
@TypeConverters(MatchDetailsTypeConvertor::class,
    SeriesConverter::class,
    VenueConverter::class,
    MatchConverter::class)
data class ExampleEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val matchDetail: MatchDetail?=null
)

fun INDNZMatchDetailsResponse.toExampleEntity() = ExampleEntity(
    matchDetail = matchDetail
)

fun ExampleEntity.toINDNZMatchDetailsResponse() = INDNZMatchDetailsResponse(
    matchDetail
)