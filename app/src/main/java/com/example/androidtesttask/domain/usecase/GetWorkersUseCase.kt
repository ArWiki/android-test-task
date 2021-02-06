package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.domain.repository.WorkerRepository
import com.example.androidtesttask.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetWorkersUseCase @Inject constructor(
    private val repository: WorkerRepository
) : SingleUseCase<MutableList<WorkerDatabase>>() {
    private var specialityId: Int? = null

    fun saveSpecialityId(specialityId: Int?) {
        this.specialityId = specialityId
    }

    override fun buildUseCaseSingle(): Single<MutableList<WorkerDatabase>> {
        return repository.getWorkersBySpecialityId(specialityId)
    }
}