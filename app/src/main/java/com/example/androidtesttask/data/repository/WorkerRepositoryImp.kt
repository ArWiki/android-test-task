package com.example.androidtesttask.data.repository

import com.example.androidtesttask.data.source.local.AppDatabase
import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.domain.repository.WorkerRepository
import io.reactivex.Single

class WorkerRepositoryImp(
    private val database: AppDatabase,
) : WorkerRepository {

    override fun getWorkersBySpecialityId(specialityId: Int?): Single<MutableList<WorkerDatabase>> {
        return database.workerDao.loadWorkerBySpecialtyId(specialityId)
    }

    override fun deleteWorker(worker: WorkerDatabase) {
        database.workerDao.delete(worker)
    }
}

