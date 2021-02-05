package com.example.androidtesttask.presentation.screeen.workersspeciality

import androidx.lifecycle.MutableLiveData
import com.example.androidtesttask.presentation.model.Speciality
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.presentation.screeen.worker.WorkerViewModel

class WorkerSpecialityViewModel(val speciality: Speciality) {
    private val TAG = WorkerViewModel::class.java.simpleName
    val specialityData = MutableLiveData<Speciality>()

    init {
        specialityData.value = speciality
    }
}