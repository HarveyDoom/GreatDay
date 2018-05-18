package com.chrishampson.greatday.presentation

import com.chrishampson.greatday.data.Task
import com.chrishampson.greatday.domain.TaskRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by chris on 17/05/18.
 */

class TaskPresenter(private val taskRepository: TaskRepository) {

    private lateinit var view: TaskContract.View
    private var calendar = Calendar.getInstance()

    var taskList: ArrayList<Task>? = null

    fun bindView(view: TaskContract.View){
        this.view = view
        updateDate()
        loadTasksForDate(calendar)
    }

    private fun loadTasksForDate(calendar: Calendar) {
        taskRepository.getTasksForDate(calendar.time)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    taskList -> view.displayTasks(taskList)
                }
    }

    private fun updateDate() {
        val format = SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH)
        view.displayDate(format.format(calendar.time))
    }

}