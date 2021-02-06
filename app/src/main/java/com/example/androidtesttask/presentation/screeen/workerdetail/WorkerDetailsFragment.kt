package com.example.androidtesttask.presentation.screeen.workerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtesttask.MainActivity
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.FragmentWorkerDetailsBinding
import com.example.androidtesttask.util.loadImageFull
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkerDetailsFragment : Fragment() {

    private lateinit var fragmentWorkerDetailsBinding: FragmentWorkerDetailsBinding
    private val viewModel: WorkerDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWorkerDetailsBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_worker_details, container, false)

        (activity as MainActivity).setSupportActionBar(fragmentWorkerDetailsBinding.detailToolbar)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        fragmentWorkerDetailsBinding.workerDetailsViewModel = viewModel

        val workerDetails =
            arguments?.getParcelable<WorkerDetailsModel>(KEY_WORKER_DETAILS_ID)
                ?: return fragmentWorkerDetailsBinding.root

        viewModel.setDetail(workerDetails)
        viewModel.checkFavoriteStatus(workerDetails)

        viewModel.workerFavoriteData.observe(viewLifecycleOwner, {
            fragmentWorkerDetailsBinding.actvFirstName.text = it?.firstName
            fragmentWorkerDetailsBinding.actvLastName.text = it?.lastName
            fragmentWorkerDetailsBinding.actvBirthday.text = it?.birthday
            fragmentWorkerDetailsBinding.actvAge.text = it?.age
            fragmentWorkerDetailsBinding.actvSpecialityName.text = it?.specialityName

            if (it?.avatarUrl == null || it.avatarUrl?.isEmpty() == true) {
                fragmentWorkerDetailsBinding
                    .detailToolbarImageView
                    .setImageResource(R.drawable.no_image_available)
            } else {
                fragmentWorkerDetailsBinding.detailToolbarImageView.loadImageFull(it.avatarUrl)
            }
        })

        viewModel.isFavorite.observe(viewLifecycleOwner, {
            it?.let {
                fragmentWorkerDetailsBinding.detailFab.setImageResource(
                    if (it)
                        R.drawable.ic_star_full_vector
                    else
                        R.drawable.ic_star_empty_white_vector
                )
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

        fragmentWorkerDetailsBinding.detailFab.setOnClickListener {
            viewModel.updateFavoriteStatus()
        }

        return fragmentWorkerDetailsBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> parentFragmentManager.popBackStackImmediate()
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val KEY_WORKER_DETAILS_ID = "KEY_WORKER_DETAILS_ID"
        val FRAGMENT_NAME = WorkerDetailsFragment::class.java.name

        @JvmStatic
        fun newInstance(workerDetailsModel: WorkerDetailsModel) =
            WorkerDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_WORKER_DETAILS_ID, workerDetailsModel)
                }
            }
    }
}