package com.example.androidtesttask.presentation.screeen.workersspeciality

import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.presentation.model.Speciality
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsModel

interface WorkersSpecialityMapper {
    fun convertWorkerResponseToSpeciality(response: WorkerResponse): List<Speciality>

    fun convertWorkerResponseToWorker(response: WorkerResponse): List<WorkerDB>

    fun convertToWorkDetailsModel(worker: Worker): WorkerDetailsModel
}

class WorkersSpecialityMapperImpl : WorkersSpecialityMapper {
    override fun convertWorkerResponseToSpeciality(response: WorkerResponse): List<Speciality> {
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

    override fun convertWorkerResponseToWorker(response: WorkerResponse): List<WorkerDB> {
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

    override fun convertToWorkDetailsModel(worker: Worker) = WorkerDetailsModel(
        worker.firstName,
        worker.lastName,
        worker.birthday,
        worker.avatarUrl,
        worker.speciality?.first()?.specialityId,
        worker.speciality?.first()?.specialityName,
    )
}