package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.domain.model.WorkerDatabase
import io.reactivex.Single

interface WorkerRepository {
    fun getWorkersBySpecialityId(specialityId: Int?): Single<MutableList<WorkerDatabase>>

    fun deleteWorker(worker: WorkerDatabase)
}