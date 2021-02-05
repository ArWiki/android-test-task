package com.example.androidtesttask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkerFavorite")
data class WorkerFavorite(
    @PrimaryKey var id: Long,
    var firstName: String?,
    var lastName: String?,
    var birthday: String?,
    var avatarUrl: String?,
    var specialityId: Int?,
    var specialityName: String?,
)