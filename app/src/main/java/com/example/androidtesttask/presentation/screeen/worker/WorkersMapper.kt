package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsModel
import com.example.androidtesttask.util.Constants.BIRTHDAY_WITH_YEAR
import com.example.androidtesttask.util.convertDate
import com.example.androidtesttask.util.toFirstUpperCase
import java.util.*

interface WorkerMapper {
    fun convertWorkerDBToWorker(worker: MutableList<WorkerDB>): List<Worker>

    fun convertToWorkDetailsModel(worker: Worker): WorkerDetailsModel
}

class WorkerMapperImpl : WorkerMapper {
    override fun convertWorkerDBToWorker(worker: MutableList<WorkerDB>): List<Worker> {
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
                    workerItem.birthday?.convertDate(),
                    workerItem.avatarUrl,
                    listSpecialty,
                )
            )
        }

        return list
    }

    override fun convertToWorkDetailsModel(worker: Worker) = WorkerDetailsModel(
        worker.firstName,
        worker.lastName,
        worker.birthday,
        worker.avatarUrl,
        worker.speciality?.first()?.specialityId,
        worker.speciality?.first()?.specialityName,
    )
}