package com.example.androidtesttask.presentation.screeen.workerdetail

import android.os.Parcel
import android.os.Parcelable

data class WorkerDetailsModel(
    val firstName: String?,
    val lastName: String?,
    val birthday: String?,
    val avatarUrl: String?,
    val specialtyId: Int?,
    val specialtyName: String?,
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(firstName)
        writeString(lastName)
        writeString(birthday)
        writeString(avatarUrl)
        writeValue(specialtyId)
        writeString(specialtyName)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<WorkerDetailsModel> =
            object : Parcelable.Creator<WorkerDetailsModel> {
                override fun createFromParcel(parcel: Parcel): WorkerDetailsModel {
                    return WorkerDetailsModel(parcel)
                }

                override fun newArray(size: Int): Array<WorkerDetailsModel?> {
                    return arrayOfNulls(size)
                }
            }
    }
}