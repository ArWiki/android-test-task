package com.example.androidtesttask.presentation.screeen.workerdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.domain.usecase.GetWorkerDetailsUseCase

class WorkerDetailsViewModel @ViewModelInject constructor(
    private val getWorkerDetailsUseCase: GetWorkerDetailsUseCase,
    private val mapper: WorkerDetailsMapper
) : ViewModel() {

    private val TAG = WorkerDetailsViewModel::class.java.simpleName
    val workerFavoriteData = MutableLiveData<WorkerFavorite>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
        isError.value = false
    }

    internal fun setDetail(workerDetailsModel: WorkerDetailsModel) {
        workerFavoriteData.value =
            mapper.convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel)
    }

    internal fun updateFavoriteStatus() {
        workerFavoriteData.value?.let { workerFavorite ->
            if (isFavorite.value == true) {
                getWorkerDetailsUseCase.deleteAsFavorite(workerFavorite)
            } else {
                getWorkerDetailsUseCase.addAsFavorite(workerFavorite)
            }
            isFavorite.value?.let {
                isFavorite.value = !it
            }
        }
    }

    internal fun checkFavoriteStatus(workerDetailsModel: WorkerDetailsModel) {
        val workerFavorite = mapper.convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel)
        getWorkerDetailsUseCase.saveWorkerFavorite(workerFavorite)
        getWorkerDetailsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                isFavorite.value = it
            },
            onError = {
                it.printStackTrace()
                isError.value = true
            }
        )
    }
}