package com.example.androidtesttask.presentation.screeen.workersspeciality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtesttask.MainActivity
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.FragmentWorkerSpecialityBinding
import com.example.androidtesttask.presentation.model.Speciality
import com.example.androidtesttask.presentation.screeen.worker.WorkersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkersSpecialityFragment : Fragment(), OnWorkersSpecialityAdapterListener {

    private lateinit var fragmentWorkersSpecialityBinding: FragmentWorkerSpecialityBinding
    private var adapter: WorkersSpecialityAdapter? = null

    private val viewModel: WorkersSpecialityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = WorkersSpecialityAdapter(this)
        viewModel.loadWorkers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWorkersSpecialityBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_worker_speciality,
            container,
            false
        )

        (activity as MainActivity).setSupportActionBar(fragmentWorkersSpecialityBinding.toolbar)

        fragmentWorkersSpecialityBinding.workersSpecialityViewModel = viewModel
        fragmentWorkersSpecialityBinding.workersRecyclerView.adapter = adapter

        viewModel.isLoad.observe(viewLifecycleOwner, {
            it?.let { visibility ->
                fragmentWorkersSpecialityBinding.workersSpecialityProgressBar.visibility =
                    if (visibility) View.GONE else View.VISIBLE
            }
        })

        viewModel.specialityReceivedLiveData.observe(viewLifecycleOwner, {
            it?.let {
                initRecyclerView(it)
            }
        })

        viewModel.isError.observe(viewLifecycleOwner, {
            it?.let { isError ->
                if (isError) {
                    Toast
                        .makeText(requireContext(), R.string.ERROR_MESSAGE, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

        return fragmentWorkersSpecialityBinding.root
    }

    private fun initRecyclerView(speciality: List<Speciality>) {
        adapter?.addData(speciality)
    }

    override fun showWorkers(specialityId: Int) {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                WorkersFragment.newInstance(specialityId),
                WorkersFragment.FRAGMENT_NAME
            )
            .addToBackStack(WorkersFragment.FRAGMENT_NAME)
            .commitAllowingStateLoss()
    }

    override fun onDetach() {
        super.onDetach()
        adapter = null
    }

    companion object {
        val FRAGMENT_NAME = WorkersSpecialityFragment::class.java.name

        @JvmStatic
        fun newInstance() =
            WorkersSpecialityFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}