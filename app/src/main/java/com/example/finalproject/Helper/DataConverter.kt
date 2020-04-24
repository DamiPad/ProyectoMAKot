package com.example.finalproject.Helper

import androidx.room.TypeConverter
import java.sql.Date
import java.sql.Timestamp
import java.util.logging.LogManager

class DataConverter {
    @TypeConverter
    fun toDate(timestamp: Long?) : java.util.Date?{
        return if(timestamp != null ) java.util.Date(timestamp) else null
    }

    @TypeConverter
    fun toTimeStamp(date: java.util.Date):Long? = date?.time
}