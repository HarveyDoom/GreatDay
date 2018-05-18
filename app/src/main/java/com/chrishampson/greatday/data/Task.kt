package com.chrishampson.greatday.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
data class Task (

        @PrimaryKey(autoGenerate = true)
        val id : Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "completed")
        var completed : Boolean,

        @ColumnInfo(name = "date_due")
        var dateDue : Date

)