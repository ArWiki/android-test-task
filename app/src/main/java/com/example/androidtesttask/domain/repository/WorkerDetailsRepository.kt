package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerFavorite
import io.reactivex.Single

interface WorkerDetailsRepository {
    fun deleteWorker(worker: WorkerFavorite)

    fun addWorker(worker: WorkerFavorite)

    fun isFavorite(worker: WorkerFavorite): Single<Boolean>
}