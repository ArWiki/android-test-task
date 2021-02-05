package com.example.androidtesttask.presentation.screeen.worker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.AdapterWorkerDescribeBinding
import com.example.androidtesttask.presentation.model.Worker
import java.util.ArrayList

internal class WorkersAdapter(val mListener: OnWorkersAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = WorkersAdapter::class.java.name
    private val workerResponses: MutableList<Worker> = ArrayList()


    /**
     * This method is called right when adapter is created &
     * is used to initialize ViewHolders
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderAlbumBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_worker_describe, parent,
            false
        )
        return AlbumViewHolder(holderAlbumBinding)
    }

    /** It is called for each ViewHolder to bind it to the adapter &
     * This is where we pass data to ViewHolder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AlbumViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Worker {
        return workerResponses[position]
    }

    /**
     * This method returns the size of collection that contains the items we want to display
     * */
    override fun getItemCount(): Int {
        return workerResponses.size
    }

    fun addData(list: List<Worker>) {
        this.workerResponses.clear()
        this.workerResponses.addAll(list)
        notifyDataSetChanged()
    }


    inner class AlbumViewHolder(
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