package com.example.androidtesttask.domain.model

import com.google.gson.annotations.SerializedName

data class WorkerResponse(
    @SerializedName("response")
    var response: List<Response>?,
) {
    data class Response(
        @SerializedName("f_name")
        var firstName: String?,
        @SerializedName("l_name")
        var lastName: String?,
        @SerializedName("birthday")
        var birthday: String?,
        @SerializedName("avatr_url")
        var avatarUrl: String?,
        @SerializedName("specialty")
        var specialty: List<Specialty>?,
    ) {
        data class Specialty(
            @SerializedName("specialty_id")
            var specialtyId: String?,
            @SerializedName("name")
            var specialtyName: String?,
        )
    }
}