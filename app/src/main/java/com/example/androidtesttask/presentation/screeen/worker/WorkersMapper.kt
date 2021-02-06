package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsModel
import com.example.androidtesttask.util.Constants.DOUBLE_HYPHEN
import com.example.androidtesttask.util.calculateAge
import com.example.androidtesttask.util.convertDate
import com.example.androidtesttask.util.toFirstUpperCase
import java.util.*
import javax.inject.Inject

class WorkerMapper @Inject constructor() {
    internal fun convertWorkerDBToWorker(worker: MutableList<WorkerDatabase>): List<Worker> {
        val list: MutableList<Worker> = mutableListOf()

        worker.forEach { workerItem ->

            val listSpecialty: MutableList<Worker.Speciality> = mutableListOf()

                listSpecialty.add(
                    Worker.Speciality(
                        workerItem.specialityId,
                        workerItem.specialityName,
                    )
                )

            list.add(
                Worker(
                    workerItem.firstName?.toLowerCase(Locale.getDefault())?.toFirstUpperCase(),
                    workerItem.lastName?.toLowerCase(Locale.getDefault())?.toFirstUpperCase(),
                    workerItem.birthday?.convertDate() ?: DOUBLE_HYPHEN,
                    workerItem.birthday?.calculateAge() ?: DOUBLE_HYPHEN,
                    workerItem.avatarUrl,
                    listSpecialty,
                )
            )
        }

        return list
    }

    internal fun convertToWorkDetailsModel(worker: Worker) = WorkerDetailsModel(
        worker.firstName,
        worker.lastName,
        worker.birthday,
        worker.avatarUrl,
        worker.speciality?.first()?.specialityId,
        worker.speciality?.first()?.specialityName,
    )
}