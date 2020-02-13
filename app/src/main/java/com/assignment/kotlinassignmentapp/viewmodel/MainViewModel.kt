package com.assignment.kotlinassignmentapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.kotlinassignmentapp.data.TodoListRepository
import com.assignment.kotlinassignmentapp.data.model.TodoModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(todoListRepository: TodoListRepository) :
    ViewModel() {

    var todoListData: MutableLiveData<List<TodoModel>> = MutableLiveData()

    init {
        todoListRepository.getTodoList().subscribe {
            todoListData.postValue(it)

        }
        todoListRepository.getTodoList().subscribe(object : Observer<List<TodoModel>> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(value: List<TodoModel>?) {
                todoListData.value = value
            }

            override fun onError(e: Throwable?) {
            }

        })



    }
}