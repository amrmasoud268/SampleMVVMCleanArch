package com.example.samplemvvmcleanarch.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.example.samplemvvmcleanarch.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    Picasso.get().load("https://image.tmdb.org/t/p/w200/$url").placeholder(R.mipmap.ic_launcher).into(this)
}

fun ImageView.loadImage(url: String, @DrawableRes placeholder: Int) {
    Picasso.get().load("https://image.tmdb.org/t/p/w200/$url").placeholder(placeholder).into(this)
}