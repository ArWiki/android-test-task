package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.domain.model.Worker

interface OnWorkersAdapterListener {
    fun showWorkerDetails(worker: Worker)
}