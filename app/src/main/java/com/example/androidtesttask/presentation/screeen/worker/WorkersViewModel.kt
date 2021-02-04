package com.example.androidtesttask.presentation.screeen.worker

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtesttask.domain.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.usecase.GetWorkersUseCase

class WorkersViewModel @ViewModelInject constructor(private val getWorkersUseCase: GetWorkersUseCase) : ViewModel() {

    private val TAG = WorkersViewModel::class.java.simpleName
    val workersReceivedLiveData = MutableLiveData<List<Worker>>()
    val isLoad = MutableLiveData<Boolean>()
    val workerData = MutableLiveData<WorkerResponse>()
    val mapper: WorkerMapper = WorkerMapperImpl()

    init {
        isLoad.value = false
    }

//    val workerResponse: WorkerResponse? get() = workerData.value
//
//    fun set(workerResponse: WorkerResponse) = run { workerData.value = workerResponse }

    fun convertToWorkDetailsModel(worker: Worker) = mapper.convertToWorkDetailsModel(worker)

    fun loadWorkers() {
        getWorkersUseCase.execute(
            onSuccess = {
                isLoad.value = true
                workersReceivedLiveData.value =
                    mapper.convertWorkerResponseToWorker(it)
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}