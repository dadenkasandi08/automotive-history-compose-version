package com.kasandi.automotivehistorycompose.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(
    val id: String,
    val name: String,
    val history: String,
    val photo: String,
    val year: String,
    val founder: String,
    val owner: String,
) : Parcelable
