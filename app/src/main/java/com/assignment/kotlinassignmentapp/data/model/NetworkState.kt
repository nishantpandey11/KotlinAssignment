package com.assignment.kotlinassignmentapp.data.model

class NetworkState constructor(
     val status: Status?,
     val msg: String?
) {

    enum class Status {
        RUNNING, SUCCESS, FAILED
    }

    companion object {
        val SUCCESS: NetworkState = NetworkState(Status.SUCCESS, "Success")
        val START: NetworkState = NetworkState(Status.RUNNING, "Running")
        val FAILED: NetworkState = NetworkState(Status.FAILED, "Failed")
    }

}