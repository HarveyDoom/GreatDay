package com.chrishampson.greatday.data.repository

import android.content.Context
import com.chrishampson.greatday.data.Task
import com.chrishampson.greatday.data.database.TaskDatabase
import com.chrishampson.greatday.domain.TaskRepository
import io.reactivex.Single
import java.util.*

/**
 * Created by chris on 16/05/18.
 */
class DatabaseTaskRepository(context: Context) : TaskRepository {

    private val db: TaskDatabase = TaskDatabase.getInstance(context)!!

    override fun getTasksForDate(date: Date): Single<List<Task>> {
        return db.taskDao().findByDate(date)
    }

    override fun saveTask(task: Task) {
        db.taskDao().insertTask(task)
    }

}