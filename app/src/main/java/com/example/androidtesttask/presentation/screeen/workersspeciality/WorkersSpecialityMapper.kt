package com.example.androidtesttask.presentation.screeen.workersspeciality

import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.presentation.model.Speciality
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsModel
import javax.inject.Inject

class WorkersSpecialityMapper @Inject constructor() {
    internal fun convertWorkerResponseToSpeciality(response: WorkerResponse): List<Speciality> {
        val list: MutableList<Speciality> = mutableListOf()

        response.response?.forEach { worker ->
            worker.speciality?.forEach {
                list.add(
                    Speciality(
                        it.specialityId,
                        it.specialityName,
                    )
                )
            }
        }

        return list.distinct()
    }

    internal fun convertWorkerResponseToWorker(response: WorkerResponse): List<WorkerDB> {
        val list: MutableList<WorkerDB> = mutableListOf()

        response.response?.forEach { worker ->
            worker.speciality?.forEach { speciality ->
                list.add(
                    WorkerDB(
                        0,
                        worker.firstName,
                        worker.lastName,
                        worker.birthday,
                        worker.avatarUrl,
                        speciality.specialityId,
                        speciality.specialityName,
                    )
                )
            }
        }

        return list
    }
}