package com.example.lojadejogos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val title: String,
    val developer: String,
    val category: String,
    val price: Double,
    val rating: Double,
    val description: String,
    val bannerRes: Int,
    val thumbnailRes: Int,
    var isPurchased: Boolean = false,
    var isInstalled: Boolean = false,
    var isFavorite: Boolean = false,
    val playTime: String? = null
) : Parcelable
