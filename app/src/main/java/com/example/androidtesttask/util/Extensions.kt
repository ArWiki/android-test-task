package com.example.androidtesttask.util

import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

fun AppCompatImageView.loadImageFull(url: String?) =
    Picasso.get().load(url).into(this)
