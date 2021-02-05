package com.example.androidtesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtesttask.presentation.screeen.workersspeciality.WorkersSpecialityFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.toolbar))

        navigateToWorkersSpecialityPage()
    }

    fun navigateToWorkersSpecialityPage() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                WorkersSpecialityFragment.newInstance(),
                WorkersSpecialityFragment.FRAGMENT_NAME
            )
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}