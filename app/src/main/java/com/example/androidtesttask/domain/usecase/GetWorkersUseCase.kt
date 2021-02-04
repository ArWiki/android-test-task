package com.example.androidtesttask.domain.usecase

import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.domain.repository.WorkerRepository
import com.example.androidtesttask.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetWorkersUseCase @Inject constructor(private val repository: WorkerRepository) : SingleUseCase<WorkerResponse>() {
    override fun buildUseCaseSingle(): Single<WorkerResponse> {
        return repository.getWorkers()
    }
}