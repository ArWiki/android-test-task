package com.example.androidtesttask.presentation.screeen.worker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.AdapterWorkerDescribeBinding
import com.example.androidtesttask.presentation.model.Worker
import java.util.*

internal class WorkersAdapter(val mListener: OnWorkersAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = WorkersAdapter::class.java.name
    private val workers: MutableList<Worker> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderWorkerBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_worker_describe, parent,
            false
        )
        return WorkersViewHolder(holderWorkerBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WorkersViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Worker {
        return workers[position]
    }

    override fun getItemCount(): Int {
        return workers.size
    }

    fun addData(list: List<Worker>) {
        this.workers.clear()
        this.workers.addAll(list)
        notifyDataSetChanged()
    }

    inner class WorkersViewHolder(
        private val dataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(dataBinding.root) {

        fun onBind(worker: Worker) {
            val holderWorkerBinding = dataBinding as AdapterWorkerDescribeBinding
            val workersViewModel = WorkerViewModel(worker)
            holderWorkerBinding.workerViewModel = workersViewModel

            itemView.setOnClickListener {
                mListener.showWorkerDetails(worker)
            }
        }
    }

}