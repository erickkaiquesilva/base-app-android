package com.example.greencode

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Page(
    val title: String,
    val subtitle: String,
    @DrawableRes val icon: Int
)