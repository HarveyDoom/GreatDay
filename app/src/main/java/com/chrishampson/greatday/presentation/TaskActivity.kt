package com.chrishampson.greatday.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.chrishampson.greatday.R
import com.chrishampson.greatday.data.repository.DatabaseTaskRepository
import com.chrishampson.greatday.data.Task
import kotlinx.android.synthetic.main.activity_today.*

class TaskActivity : AppCompatActivity(), TaskContract.View {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var presenter: TaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)

        taskAdapter = TaskAdapter(this)
        task_list_rv.layoutManager = LinearLayoutManager(this)
        task_list_rv.adapter = taskAdapter

        val taskRepository = DatabaseTaskRepository(this)
        presenter = TaskPresenter(taskRepository)
        presenter.bindView(this)
    }

    override fun displayDate(dateString: String) {
        today_date.text = dateString
    }

    override fun displayTasks(taskList: List<Task>) {
        taskAdapter.setTaskList(taskList)
    }

    override fun displayDailyScore(score: Int) {
        daily_score.text = "Daily Score:" + score.toString()
    }
}

