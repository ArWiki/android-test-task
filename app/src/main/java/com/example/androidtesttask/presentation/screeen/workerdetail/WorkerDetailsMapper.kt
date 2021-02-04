package com.example.androidtesttask.presentation.screeen.workerdetail

import com.example.androidtesttask.domain.model.WorkerFavorite

interface WorkerDetailsMapper {
    fun convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel: WorkerDetailsModel): WorkerFavorite
}

class WorkerDetailsMapperImpl : WorkerDetailsMapper {
    override fun convertWorkerDetailsModelToWorkerFavorite(workerDetailsModel: WorkerDetailsModel): WorkerFavorite {
        return WorkerFavorite(
            id = 1L,
            firstName = workerDetailsModel.firstName,
            lastName = workerDetailsModel.lastName,
            avatarUrl = workerDetailsModel.avatarUrl,
            birthday = workerDetailsModel.birthday,
            specialtyId = workerDetailsModel.specialtyId,
            specialtyName = workerDetailsModel.specialtyName,
        )
    }
}