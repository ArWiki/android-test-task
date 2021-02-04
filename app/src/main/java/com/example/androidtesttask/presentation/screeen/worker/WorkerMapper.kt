package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.domain.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse

interface WorkerMapper {
    fun convertWorkerResponseToWorker(response: WorkerResponse): List<Worker>
}

class WorkerMapperImpl : WorkerMapper {
    override fun convertWorkerResponseToWorker(response: WorkerResponse): List<Worker> {
        val list: MutableList<Worker> = mutableListOf()
        val listSpecialty: MutableList<Worker.Specialty> = mutableListOf()

        response.response?.forEach { worker ->

            listSpecialty.clear()

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
}