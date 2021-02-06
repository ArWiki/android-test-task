package com.example.androidtesttask.presentation.screeen.workerdetail

import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.util.Constants.DOUBLE_HYPHEN
import com.example.androidtesttask.util.calculateAge
import com.example.androidtesttask.util.toFirstUpperCase
import java.util.*
import javax.inject.Inject

class WorkerDetailsMapper @Inject constructor() {
    internal fun convertWorkerDetailsModelToWorkerFavorite(
        workerDetailsModel: WorkerDetailsModel
    ): WorkerFavorite {
        return WorkerFavorite(
            id = 0,
            firstName = workerDetailsModel.firstName
                ?.toLowerCase(Locale.getDefault())
                ?.toFirstUpperCase(),
            lastName = workerDetailsModel.lastName
                ?.toLowerCase(Locale.getDefault())
                ?.toFirstUpperCase(),
            avatarUrl = workerDetailsModel.avatarUrl,
            birthday = workerDetailsModel.birthday,
            age = workerDetailsModel.birthday?.calculateAge() ?: DOUBLE_HYPHEN,
            specialityId = workerDetailsModel.specialtyId,
            specialityName = workerDetailsModel.specialtyName,
        )
    }
}