package com.example.androidtesttask.data.repository

import com.example.androidtesttask.data.source.local.AppDatabase
import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.domain.repository.WorkerDetailsRepository

class WorkerDetailsRepositoryImp(
    private val database: AppDatabase,
) : WorkerDetailsRepository {
    override fun deleteWorker(worker: WorkerFavorite) {
        database.workerDao.deleteWorkerFavorite(worker)
    }

    override fun addWorker(worker: WorkerFavorite) {
        database.workerDao.insertWorkerFavorite(worker)
    }

    override fun isFavorite(worker: WorkerFavorite): Boolean {
        val loadOneByPhotoId = database.workerDao.isFavorite(
            worker.lastName,
            worker.firstName,
            worker.birthday)
        return loadOneByPhotoId != null
    }
}
