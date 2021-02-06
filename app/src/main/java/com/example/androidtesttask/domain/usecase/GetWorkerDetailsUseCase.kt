package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.domain.repository.WorkerDetailsRepository
import com.example.androidtesttask.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetWorkerDetailsUseCase @Inject constructor(
    private val repository: WorkerDetailsRepository
) : SingleUseCase<Boolean>() {

    private lateinit var worker: WorkerFavorite

    fun saveWorkerFavorite(worker: WorkerFavorite) {
        this.worker = worker
    }

    override fun buildUseCaseSingle(): Single<Boolean> {
        return repository.isFavorite(worker)
    }

    fun deleteAsFavorite(worker: WorkerFavorite) {
        repository.deleteWorker(worker)
    }

    fun addAsFavorite(worker: WorkerFavorite) {
        repository.addWorker(worker)
    }
}