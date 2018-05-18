package com.chrishampson.greatday.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.chrishampson.greatday.data.Task
import io.reactivex.Single
import java.util.*


/**
 * Created by chris on 16/05/18.
 */

@Dao
interface TaskDao {

    @Query("SELECT * FROM task WHERE date_due LIKE :date")
    fun findByDate(date: Date): Single<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

}