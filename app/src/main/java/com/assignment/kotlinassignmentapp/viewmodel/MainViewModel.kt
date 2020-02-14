package com.assignment.kotlinassignmentapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.kotlinassignmentapp.data.TodoListRepository
import com.assignment.kotlinassignmentapp.data.model.NetworkState
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(val todoListRepository: TodoListRepository) :
    ViewModel() {

    var todoListData: MutableLiveData<List<TodoModel>> = MutableLiveData()
    var networkState: MutableLiveData<NetworkState> = MutableLiveData()


    init {
        getTodoList()
    }

    fun getTodoList() {
        networkState.value = NetworkState.START
        todoListRepository.getTodoList().subscribe(object : Observer<List<TodoModel>> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(value: List<TodoModel>?) {
                networkState.postValue(NetworkState.SUCCESS)
                todoListData.postValue(value)
            }

            override fun onError(e: Throwable?) {
                networkState.postValue(NetworkState.ERROR)
            }

        })
    }
}