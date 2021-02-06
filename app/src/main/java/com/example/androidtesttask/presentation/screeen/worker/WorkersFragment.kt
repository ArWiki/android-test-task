package com.example.androidtesttask.presentation.screeen.worker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.FragmentWorkersBinding
import androidx.databinding.DataBindingUtil
import com.example.androidtesttask.MainActivity
import com.example.androidtesttask.presentation.model.Worker
import com.example.androidtesttask.presentation.screeen.workerdetail.WorkerDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkersFragment : Fragment(), OnWorkersAdapterListener {

    private lateinit var fragmentAlbumsBinding: FragmentWorkersBinding
    private var adapter: WorkersAdapter? = null

    private val viewModel: WorkersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        adapter = WorkersAdapter(this)
        val specialityId = arguments?.let { it.getInt(KEY_SPECIALITY_ID) }
        viewModel.loadWorkers(specialityId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAlbumsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_workers,
            container,
            false
        )

        (activity as MainActivity).setSupportActionBar(fragmentAlbumsBinding.toolbar)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        fragmentAlbumsBinding.workersViewModel = viewModel
        fragmentAlbumsBinding.albumsRecyclerView.adapter = adapter

        viewModel.isLoad.observe(viewLifecycleOwner, Observer {
            it?.let { visibility ->
                fragmentAlbumsBinding.albumsProgressBar.visibility =
                    if (visibility) View.GONE else View.VISIBLE
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
        adapter?.addData(workers)
    }

    override fun showWorkerDetails(worker: Worker) {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                WorkerDetailsFragment.newInstance(viewModel.convertToWorkDetailsModel(worker)),
                WorkerDetailsFragment.FRAGMENT_NAME
            )
            .addToBackStack(WorkerDetailsFragment.FRAGMENT_NAME)
            .commitAllowingStateLoss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> parentFragmentManager.popBackStackImmediate()
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDetach() {
        super.onDetach()
        adapter = null
    }

    companion object {
        val FRAGMENT_NAME = WorkersFragment::class.java.name
        const val KEY_SPECIALITY_ID = "KEY_SPECIALITY_ID"

        @JvmStatic
        fun newInstance(specialityId: Int) =
            WorkersFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_SPECIALITY_ID, specialityId)
                }
            }
    }
}