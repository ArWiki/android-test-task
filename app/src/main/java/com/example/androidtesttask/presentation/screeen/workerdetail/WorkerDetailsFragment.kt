package com.example.androidtesttask.presentation.screeen.workerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtesttask.R
import com.example.androidtesttask.databinding.FragmentWorkerDetailsBinding
import com.example.androidtesttask.util.loadImageFull
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkerDetailsFragment : Fragment() {

    private val TAG = WorkerDetailsFragment::class.java.name
    private lateinit var fragmentWorkerDetailsBinding: FragmentWorkerDetailsBinding
    private val viewModel: WorkerDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWorkerDetailsBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_worker_details, container, false)

        fragmentWorkerDetailsBinding.workerDetailsViewModel = viewModel

        val workerDetails =
            arguments?.getParcelable<WorkerDetailsModel>(KEY_WORKER_DETAILS_ID)
                ?: return fragmentWorkerDetailsBinding.root

        viewModel.setDetail(workerDetails)
        viewModel.checkFavoriteStatus(workerDetails)

        viewModel.workerFavoriteData.observe(viewLifecycleOwner, {
            fragmentWorkerDetailsBinding.detailTitleTextView.text = it?.lastName

            if (it?.avatarUrl?.isEmpty() == true) {
                fragmentWorkerDetailsBinding.detailToolbarImageView.setImageResource(R.drawable.no_image_available)
            } else {
                fragmentWorkerDetailsBinding.detailToolbarImageView.loadImageFull(it?.avatarUrl)
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

        fragmentWorkerDetailsBinding.detailFab.setOnClickListener {
            viewModel.updateFavoriteStatus()
        }

        return fragmentWorkerDetailsBinding.root
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