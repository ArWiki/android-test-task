package com.example.androidtesttask.presentation.screeen.workersspeciality

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtesttask.domain.usecase.GetWorkersSpecialityUseCase
import com.example.androidtesttask.presentation.model.Speciality

class WorkersSpecialityViewModel @ViewModelInject constructor(
    private val getWorkersSpecialityUseCase: GetWorkersSpecialityUseCase,
    private val mapper: WorkersSpecialityMapper
) : ViewModel() {

    private val TAG = WorkersSpecialityViewModel::class.java.simpleName
    val specialityReceivedLiveData = MutableLiveData<List<Speciality>>()
    val isLoad = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
        isError.value = false
    }

    internal fun loadWorkers() {
        getWorkersSpecialityUseCase.execute(
            onSuccess = {
                isLoad.value = true
                specialityReceivedLiveData.value =
                    mapper.convertWorkerResponseToSpeciality(it)

                getWorkersSpecialityUseCase.deleteAll()
                getWorkersSpecialityUseCase.addWorkers(mapper.convertWorkerResponseToWorker(it))
            },
            onError = {
                it.printStackTrace()
                isError.value = true
            }
        )
    }
}