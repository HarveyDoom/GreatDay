package com.chrishampson.greatday.presentation

import com.chrishampson.greatday.data.Task

/**
 * Created by chris on 17/05/18.
 */
interface TaskContract {

    interface View {

        fun displayDate(dateString: String)

        fun displayTasks(taskList: List<Task>)

        fun displayDailyScore(score: Int)

    }
}