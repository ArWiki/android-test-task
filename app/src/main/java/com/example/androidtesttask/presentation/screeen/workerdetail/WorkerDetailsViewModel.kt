package com.example.androidtesttask.presentation.screeen.workerdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.domain.usecase.GetWorkerDetailsUseCase

class WorkerDetailsViewModel @ViewModelInject constructor(
    private val getWorkerDetailsUseCase: GetWorkerDetailsUseCase
) : ViewModel() {

    private val TAG = WorkerDetailsViewModel::class.java.simpleName
    val workerFavoriteData = MutableLiveData<WorkerFavorite>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()
    val mapper: WorkerDetailsMapper = WorkerDetailsMapperImpl()

    init {
        isLoad.value = false
    }

    fun setDetail(workerDetailsModel: WorkerDetailsModel) {
        isLoad.value = true
        workerFavoriteData.value =
            mapper.convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel)
    }

    fun updateFavoriteStatus() {
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

    fun checkFavoriteStatus(workerDetailsModel: WorkerDetailsModel) {
        val workerFavorite = mapper.convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel)
        isFavorite.value = getWorkerDetailsUseCase.isFavorite(workerFavorite)
    }
}