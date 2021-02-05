package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerFavorite

interface WorkerDetailsRepository {
    fun deleteWorker(worker: WorkerFavorite)

    fun addWorker(worker: WorkerFavorite)

    fun isFavorite(worker: WorkerFavorite): Boolean
}