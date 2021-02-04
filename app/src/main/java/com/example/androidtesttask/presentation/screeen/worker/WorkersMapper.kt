package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.domain.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsModel

interface WorkerMapper {
    fun convertWorkerResponseToWorker(response: WorkerResponse): List<Worker>

    fun convertToWorkDetailsModel(worker: Worker): WorkerDetailsModel
}

class WorkerMapperImpl : WorkerMapper {
    override fun convertWorkerResponseToWorker(response: WorkerResponse): List<Worker> {
        val list: MutableList<Worker> = mutableListOf()

        response.response?.forEach { worker ->

            val listSpecialty: MutableList<Worker.Specialty> = mutableListOf()

            worker.specialty?.forEach {
                listSpecialty.add(
                    Worker.Specialty(
                        it.specialtyId,
                        it.specialtyName,
                    )
                )
            }

            list.add(
                Worker(
                    worker.firstName,
                    worker.lastName,
                    worker.birthday,
                    worker.avatarUrl,
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
        worker.specialty?.first()?.specialtyId,
        worker.specialty?.first()?.specialtyName,
    )
}