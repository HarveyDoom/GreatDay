package com.chrishampson.greatday.domain

import com.chrishampson.greatday.data.Task
import io.reactivex.Single
import java.util.*

/**
 * Created by chris on 16/05/18.
 */
interface TaskRepository {

    fun getTasksForDate(date: Date): Single<List<Task>>

    fun saveTask(task: Task)

}