package com.example.androidtesttask.data.api.repository

import com.example.androidtesttask.data.api.responses.CountryResponse
import com.example.androidtesttask.data.utils.ApiPaths
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCountryRepository {
    @GET(ApiPaths.COUNTRY_NEWS)
    fun loadCountryNews(@Path("countPage") countPage: Int) : Single<CountryResponse>
}