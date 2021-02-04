package com.example.androidtesttask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Worker")
data class WorkerDB(
    @PrimaryKey var id: Long,
    var firstName: String?,
    var lastName: String?,
    var birthday: String?,
    var avatarUrl: String?,
    //var specialty: Specialty?,
    var specialtyId: String?,
    var specialtyName: String?,
) {
//    data class Specialty(
//        var specialtyId: String?,
//        var specialtyName: String?,
//    )
}