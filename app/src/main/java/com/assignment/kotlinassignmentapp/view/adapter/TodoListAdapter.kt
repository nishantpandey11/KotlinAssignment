package com.assignment.kotlinassignmentapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.kotlinassignmentapp.R
import com.assignment.kotlinassignmentapp.data.model.NetworkState
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import com.assignment.kotlinassignmentapp.databinding.NetworkItemBinding
import com.assignment.kotlinassignmentapp.databinding.TodoItemBinding

class TodoListAdapter : ListAdapter<TodoModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    val TYPE_PROGRESS = 0
    val TYPE_ITEM = 1
    lateinit var networkState:NetworkState

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_PROGRESS) {
            val networkItemBinding: NetworkItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.network_state_item, parent, false
            )
            return NetworkStateItemViewHolder(networkItemBinding)

        } else {
            val itemBinding: TodoItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.todo_item, parent, false
            )
            return TodoViewHolder(itemBinding)
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is TodoViewHolder ){
            val currentDelivery: TodoModel? = getItem(position)
            holder.bind(currentDelivery)
        } else {
            (holder as NetworkStateItemViewHolder).bindView(networkState)
        }

    }

    private fun isDataLoaded():Boolean {
        return networkState.status !== NetworkState.Status.SUCCESS
    }

    override fun getItemViewType(position: Int): Int {
        return if(isDataLoaded()){
            TYPE_ITEM
        } else{
            TYPE_PROGRESS
        }
    }


    inner class TodoViewHolder(private val itemBinding: TodoItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(delivery: TodoModel?) {
            itemBinding.viewModel = delivery

        }

    }
    inner class NetworkStateItemViewHolder(private val binding: NetworkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(networkState: NetworkState?) {
            if (networkState?.status === NetworkState.Status.RUNNING) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
            if (networkState?.status === NetworkState.Status.FAILED) {
                binding.errorMsg.visibility = View.VISIBLE
                binding.errorMsg.text = networkState.msg
            } else {
                binding.errorMsg.visibility = View.GONE
            }
        }

    }

}