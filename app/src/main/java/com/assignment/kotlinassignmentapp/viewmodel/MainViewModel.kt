package com.assignment.kotlinassignmentapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.kotlinassignmentapp.data.TodoListRepository
import com.assignment.kotlinassignmentapp.data.model.NetworkState
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val todoListRepository: TodoListRepository) :
    ViewModel() {

    var todoListData: MutableLiveData<List<TodoModel>> = MutableLiveData()
    var networkState: MutableLiveData<NetworkState> = MutableLiveData()


    init {
        getTodoList()
    }

    fun getTodoList() {
        networkState.value = NetworkState.START
        viewModelScope.launch {
            try {
                val result = todoListRepository.getTodo()
                networkState.postValue(NetworkState.SUCCESS)
                todoListData.postValue(result)
            } catch (e: Exception) {
                networkState.postValue(NetworkState.ERROR)
            }

        }

    }
}