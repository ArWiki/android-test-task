package com.example.androidtesttask.data.repository

import com.example.androidtesttask.data.source.local.AppDatabase
import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.repository.WorkerRepository
import io.reactivex.Single

class WorkerRepositoryImp(
    private val database: AppDatabase,
) : WorkerRepository {

    override fun getWorkersBySpecialityId(specialityId: Int?): Single<MutableList<WorkerDB>> {
        return database.workerDao.loadWorkerBySpecialtyId(specialityId)
    }

    override fun deleteWorker(worker: WorkerDB) {
        database.workerDao.delete(worker)
    }
}

