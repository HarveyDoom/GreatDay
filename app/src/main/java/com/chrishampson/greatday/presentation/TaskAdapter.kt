package com.chrishampson.greatday.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrishampson.greatday.R
import com.chrishampson.greatday.data.Task
import kotlinx.android.synthetic.main.task_list_item.view.*
import java.util.*

class TaskAdapter(private val context: Context)
                 : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var tasks : List<Task> = Collections.emptyList()

    fun setTaskList(taskList: List<Task>) {
        this.tasks = taskList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTitleTv.text = task.title
        holder.taskCheckBox.isChecked = task.completed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitleTv = view.task_title!!
        val taskCheckBox = view.task_check_box!!
    }


}