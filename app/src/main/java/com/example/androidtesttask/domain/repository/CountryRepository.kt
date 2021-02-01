package com.example.androidtesttask.domain.repository

import com.example.androidtesttask.data.api.responses.CountryResponse
import io.reactivex.rxjava3.core.Single

interface CountryRepository {
    fun loadCountryNews(countNews: Int) : Single<CountryResponse>
}