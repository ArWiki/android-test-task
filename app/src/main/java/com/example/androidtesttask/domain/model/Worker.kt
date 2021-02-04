package com.example.androidtesttask.domain.model

data class Worker(
    var firstName: String?,
    var lastName: String?,
    var birthday: String?,
    var avatarUrl: String?,
    var specialty: List<Specialty>?,
) {
    data class Specialty(
        var specialtyId: Int?,
        var specialtyName: String?,
    )
}