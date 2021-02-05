package com.example.androidtesttask.presentation.screeen.worker

import com.example.androidtesttask.presentation.model.Worker

interface OnWorkersAdapterListener {
    fun showWorkerDetails(worker: Worker)
}