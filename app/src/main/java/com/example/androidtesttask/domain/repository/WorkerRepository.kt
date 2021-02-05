package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.model.WorkerDB
import io.reactivex.Single

interface WorkerRepository {
    fun getWorkersBySpecialityId(specialityId: Int?): Single<MutableList<WorkerDB>>

    fun deleteWorker(worker: WorkerDB)
}