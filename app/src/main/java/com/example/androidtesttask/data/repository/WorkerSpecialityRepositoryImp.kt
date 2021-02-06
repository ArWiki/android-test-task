package com.example.androidtesttask.data.repository

import com.example.androidtesttask.data.source.local.AppDatabase
import com.example.androidtesttask.data.source.remote.RetrofitService
import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.repository.WorkerSpecialityRepository
import io.reactivex.Single

class WorkerSpecialityRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
) : WorkerSpecialityRepository {
    override fun getWorkers(): Single<WorkerResponse> {
        return retrofitService.getWorkers()
    }

    override fun addWorker(worker: WorkerDatabase) {
        database.workerDao.insert(worker)
    }

    override fun deleteAll() {
        database.workerDao.deleteAll()
    }
}