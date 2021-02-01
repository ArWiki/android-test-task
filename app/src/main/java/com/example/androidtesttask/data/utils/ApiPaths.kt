package com.example.androidtesttask.data.utils

class ApiPaths {
    companion object {
        private const val API_KEY = "cc80e044a56a4816a51722e1c8a0f34c";
        private const val V2 = "v2/";

        const val COUNTRY_NEWS: String = V2 + "top-headlines?country=us&pageSize={pageCount}&apiKey=" + API_KEY
    }
}