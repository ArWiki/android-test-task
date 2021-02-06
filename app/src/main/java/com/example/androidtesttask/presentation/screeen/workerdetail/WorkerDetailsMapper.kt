package com.example.androidtesttask.presentation.screeen.workerdetail

import com.example.androidtesttask.domain.model.WorkerFavorite
import com.example.androidtesttask.util.Constants.DOUBLE_HYPHEN
import com.example.androidtesttask.util.Constants.LOCAL_DATE_DD_MM_YYYY
import com.example.androidtesttask.util.toFirstUpperCase
import java.text.SimpleDateFormat
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
            age = calculateAge(workerDetailsModel.birthday),
            specialityId = workerDetailsModel.specialtyId,
            specialityName = workerDetailsModel.specialtyName,
        )
    }

    private fun calculateAge(birthday: String?): String {
        return if (birthday == null || birthday.isEmpty() || birthday == DOUBLE_HYPHEN) {
            DOUBLE_HYPHEN
        } else {
            val formatter = SimpleDateFormat(LOCAL_DATE_DD_MM_YYYY, Locale.ENGLISH)
            val date: Date? = formatter.parse(birthday)
            val birthdayCal: Calendar = Calendar.getInstance()
            birthdayCal.timeInMillis = date?.time ?: 0L
            val todayCal: Calendar = Calendar.getInstance()
            var age: Int = todayCal.get(Calendar.YEAR) - birthdayCal.get(Calendar.YEAR)
            if (todayCal.get(Calendar.DAY_OF_MONTH) < birthdayCal.get(Calendar.DAY_OF_MONTH)) {
                age--
            }
            age.toString()
        }
    }
}