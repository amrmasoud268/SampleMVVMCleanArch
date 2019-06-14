package com.example.samplemvvmcleanarch.domin.models

/**
 * NetworkState is a good common example for handling the network response with status type.
 */

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
        val status: Status,
        val message: String? = null
) {
    companion object {
        val LOADING = NetworkState(Status.RUNNING)
        val Success = NetworkState(Status.SUCCESS)
        fun Error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}
