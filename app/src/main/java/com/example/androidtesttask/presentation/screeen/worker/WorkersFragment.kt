package com.example.androidtesttask.presentation.screeen.worker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.FragmentWorkersBinding
import androidx.databinding.DataBindingUtil
import com.example.androidtesttask.domain.model.Worker
import com.example.androidtesttask.domain.model.WorkerResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkersFragment : Fragment() {

    private lateinit var fragmentAlbumsBinding: FragmentWorkersBinding
    private var adapter: WorkersAdapter? = null

    private val viewModel: WorkersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = WorkersAdapter()
        viewModel.loadWorkers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentAlbumsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_workers, container, false)
        fragmentAlbumsBinding.workersViewModel = viewModel
        fragmentAlbumsBinding.albumsRecyclerView.adapter = adapter

        viewModel.isLoad.observe(viewLifecycleOwner, Observer {
            it?.let { visibility ->
                fragmentAlbumsBinding.albumsProgressBar.visibility = if (visibility) View.GONE else View.VISIBLE
            }
        })

        viewModel.workersReceivedLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                initRecyclerView(it)
            }
        })

        return fragmentAlbumsBinding.root
    }

    private fun initRecyclerView(workers: List<Worker>) {
        Log.i("WorkersFragment", workers.toString())
        adapter?.addData(workers)
    }

    override fun onDetach() {
        super.onDetach()
        adapter = null
    }


    companion object {
        val FRAGMENT_NAME = WorkersFragment::class.java.name

        @JvmStatic
        fun newInstance() =
            WorkersFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}