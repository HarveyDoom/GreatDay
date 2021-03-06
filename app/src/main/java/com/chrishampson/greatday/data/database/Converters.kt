package com.chrishampson.greatday.data.database

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by chris on 16/05/18.
 */
class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return (date?.time)!!.toLong()
    }
}
