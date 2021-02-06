package com.example.androidtesttask.data.source.remote

import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.util.Constants.GET_WORKERS
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET(GET_WORKERS)
    fun getWorkers(): Single<WorkerResponse>
}