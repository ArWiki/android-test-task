package com.example.androidtesttask.presentation.screeen.worker

import androidx.lifecycle.MutableLiveData
import com.example.androidtesttask.presentation.model.Worker

class WorkerViewModel(val worker: Worker) {

    val workerData = MutableLiveData<Worker>()

    init {
        workerData.value = worker
    }
}