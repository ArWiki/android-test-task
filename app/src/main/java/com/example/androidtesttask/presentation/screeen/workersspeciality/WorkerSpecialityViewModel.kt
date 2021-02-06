package com.example.androidtesttask.presentation.screeen.workersspeciality

import androidx.lifecycle.MutableLiveData
import com.example.androidtesttask.presentation.model.Speciality

class WorkerSpecialityViewModel(val speciality: Speciality) {
    private val specialityData = MutableLiveData<Speciality>()

    init {
        specialityData.value = speciality
    }
}