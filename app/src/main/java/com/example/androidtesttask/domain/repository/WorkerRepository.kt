package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.model.WorkerDB
import io.reactivex.Single

interface WorkerRepository {
    fun getWorkers(): Single<WorkerResponse>

    fun deleteWorker(worker: WorkerDB)

    fun addWorker(worker: WorkerDB)
}