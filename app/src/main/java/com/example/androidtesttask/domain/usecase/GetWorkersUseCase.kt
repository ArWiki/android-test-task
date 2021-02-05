package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.repository.WorkerRepository
import com.example.androidtesttask.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetWorkersUseCase @Inject constructor(
    private val repository: WorkerRepository
) : SingleUseCase<MutableList<WorkerDB>>() {
    private var specialityId: Int? = null

    fun saveSpecialityId(specialityId: Int?) {
        this.specialityId = specialityId
    }

    override fun buildUseCaseSingle(): Single<MutableList<WorkerDB>> {
        return repository.getWorkersBySpecialityId(specialityId)
    }
}