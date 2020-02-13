package com.assignment.kotlinassignmentapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.kotlinassignmentapp.R
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import com.assignment.kotlinassignmentapp.databinding.TodoItemBinding

class TodoListAdapter : ListAdapter<TodoModel, TodoListAdapter.TodoViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<TodoModel> =
            object : DiffUtil.ItemCallback<TodoModel>() {
                override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
                    return oldItem.id == newItem.id && oldItem.userId == newItem.userId
                            && oldItem.completed == newItem.completed && oldItem.title == newItem.title
                }
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemBinding: TodoItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.todo_item, parent, false
        )
        return TodoViewHolder(itemBinding)

    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentDelivery: TodoModel? = getItem(position)
        holder.bind(currentDelivery)
    }


    inner class TodoViewHolder(private val itemBinding: TodoItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(delivery: TodoModel?) {
            itemBinding.viewModel = delivery

        }

    }

}