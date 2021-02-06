package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.repository.WorkerSpecialityRepository
import com.example.androidtesttask.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetWorkersSpecialityUseCase @Inject constructor(
    private val repository: WorkerSpecialityRepository
) : SingleUseCase<WorkerResponse>() {
    override fun buildUseCaseSingle(): Single<WorkerResponse> {
        return repository.getWorkers()
    }

    fun addWorkers(workers: List<WorkerDatabase>) {
        workers.forEach {
            repository.addWorker(it)
        }
    }

    fun deleteAll() {
        repository.deleteAll()
    }
}