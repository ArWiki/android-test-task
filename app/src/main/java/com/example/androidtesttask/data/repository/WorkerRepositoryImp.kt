package com.example.androidtesttask.data.repository

import com.example.androidtesttask.data.source.local.AppDatabase
import com.example.androidtesttask.data.source.remote.RetrofitService
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.repository.WorkerRepository
import io.reactivex.Single

class WorkerRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
) : WorkerRepository {
    override fun getWorkers(): Single<WorkerResponse> {
        return retrofitService.getWorkers()
    }

    override fun deleteWorker(worker: WorkerDB) {
        database.workerDao.delete(worker)
    }

    override fun addWorker(worker: WorkerDB) {
        database.workerDao.insert(worker)
    }
}

