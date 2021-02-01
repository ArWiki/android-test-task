package com.example.androidtesttask.data.api.remote

import com.example.androidtesttask.data.api.repository.ApiCountryRepository
import com.example.androidtesttask.domain.repository.CountryRepository

class RemoteCountryRepository(
    val apiCountryRepository: ApiCountryRepository
    ) : CountryRepository {
    override fun loadCountryNews(countNews: Int) = apiCountryRepository.loadCountryNews(countNews)
}