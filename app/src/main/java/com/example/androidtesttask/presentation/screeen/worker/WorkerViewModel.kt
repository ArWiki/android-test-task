package com.example.androidtesttask.presentation.screeen.worker

import androidx.lifecycle.MutableLiveData
import com.example.androidtesttask.domain.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse

class WorkerViewModel(val worker: Worker) {

    private val TAG = WorkerViewModel::class.java.simpleName
    val workerData = MutableLiveData<Worker>()

    init {
        workerData.value = worker
    }

}