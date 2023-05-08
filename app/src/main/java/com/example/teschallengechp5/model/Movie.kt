package com.example.teschallengechp5.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Movie(
    val title:String,
    val overview:String,
    val releaseDate:String,
    val imagePath:String
): Parcelable