package com.example.androidtesttask.presentation.model

data class Worker(
    var firstName: String?,
    var lastName: String?,
    var birthday: String?,
    var age: String?,
    var avatarUrl: String?,
    var speciality: List<Speciality>?,
) {
    data class Speciality(
        var specialityId: Int?,
        var specialityName: String?,
    )
}