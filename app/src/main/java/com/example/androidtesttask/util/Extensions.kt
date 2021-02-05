package com.example.androidtesttask.util

import androidx.appcompat.widget.AppCompatImageView
import com.example.androidtesttask.util.Constants.DOUBLE_HYPHEN
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

fun AppCompatImageView.loadImageFull(url: String?) =
    Picasso.get().load(url).into(this)

fun String.toFirstUpperCase(): String {
    return if (this.isEmpty()) {
        ""
    } else {
        this.substring(0, 1).toUpperCase(Locale.getDefault()) + this.substring(1)
    }
}

fun String.convertDate(): String {
    return if (this.isEmpty()) {
        DOUBLE_HYPHEN
    } else {
        val formatter = if (this.substring(4, 5) == Constants.HYPHEN) {
            SimpleDateFormat(Constants.JSON_DATE_YYYY_MM_DD, Locale.ENGLISH)
        } else {
            SimpleDateFormat(Constants.JSON_DATE_DD_MM_YYYY, Locale.ENGLISH)
        }

        val date: Date? = formatter.parse(this)
        val dateFormat = SimpleDateFormat(Constants.LOCAL_DATE_DD_MM_YYYY, Locale.ENGLISH)
        dateFormat.format(date ?: Constants.DOUBLE_HYPHEN) + Constants.BIRTHDAY_WITH_YEAR
    }
}