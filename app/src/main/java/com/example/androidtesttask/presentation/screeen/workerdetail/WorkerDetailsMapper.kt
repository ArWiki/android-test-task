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
            0,
            workerDetailsModel.firstName
                ?.toLowerCase(Locale.getDefault())
                ?.toFirstUpperCase(),
            workerDetailsModel.lastName
                ?.toLowerCase(Locale.getDefault())
                ?.toFirstUpperCase(),
            workerDetailsModel.birthday,
            workerDetailsModel.birthday
                ?.calculateAge() ?: DOUBLE_HYPHEN,
            workerDetailsModel.avatarUrl,
            workerDetailsModel.specialtyId,
            workerDetailsModel.specialtyName,
        )
    }
}