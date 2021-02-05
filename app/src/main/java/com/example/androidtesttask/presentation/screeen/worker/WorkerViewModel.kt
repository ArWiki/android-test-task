package com.example.androidtesttask.presentation.screeen.worker

import androidx.lifecycle.MutableLiveData
import com.example.androidtesttask.presentation.model.Worker

class WorkerViewModel(val worker: Worker) {

    private val TAG = WorkerViewModel::class.java.simpleName
    val workerData = MutableLiveData<Worker>()

    init {
        workerData.value = worker
    }
}