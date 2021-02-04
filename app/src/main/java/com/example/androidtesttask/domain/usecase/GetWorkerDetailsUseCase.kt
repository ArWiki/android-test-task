package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.domain.repository.WorkerDetailsRepository
import javax.inject.Inject

class GetWorkerDetailsUseCase @Inject constructor(private val repository: WorkerDetailsRepository) {
    fun deleteAsFavorite(worker: WorkerFavorite) {
        repository.deleteWorker(worker)
    }

    fun addAsFavorite(worker: WorkerFavorite) {
        repository.addWorker(worker)
    }

    fun isFavorite(worker: WorkerFavorite): Boolean {
        return repository.isFavorite(worker)
    }
}