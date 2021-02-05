package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.model.WorkerResponse
import io.reactivex.Single

interface WorkerSpecialityRepository {
    fun getWorkers(): Single<WorkerResponse>

    fun addWorker(worker: WorkerDB)

    fun deleteAll()
}