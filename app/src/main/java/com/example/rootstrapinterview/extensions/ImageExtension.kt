package com.example.rootstrapinterview.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Maxi
 * since 19/12/2020
 */

fun ImageView.loadImageBitmap(url: String) {
    Glide.with(context).load(url).into(this)
}