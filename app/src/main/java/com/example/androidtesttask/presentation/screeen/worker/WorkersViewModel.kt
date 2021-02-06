package com.example.androidtesttask.presentation.screeen.worker

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.domain.usecase.GetWorkersUseCase

class WorkersViewModel @ViewModelInject constructor(
    private val getWorkersUseCase: GetWorkersUseCase,
    private val mapper: WorkerMapper
) : ViewModel() {

    val workersReceivedLiveData = MutableLiveData<List<Worker>>()
    val isLoad = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
        isError.value = false
    }

    internal fun convertToWorkDetailsModel(worker: Worker) = mapper.convertToWorkDetailsModel(worker)

    internal fun loadWorkers(specialityId: Int?) {
        getWorkersUseCase.saveSpecialityId(specialityId)
        getWorkersUseCase.execute(
            onSuccess = {
                isLoad.value = true
                workersReceivedLiveData.value =
                    mapper.convertWorkerDBToWorker(it)
            },
            onError = {
                it.printStackTrace()
                isError.value = true
            }
        )
    }
}