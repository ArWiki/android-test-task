package com.example.androidtesttask.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImageFull(url: String?) =
    Picasso.get().load(url).into(this)
