package com.irpansyam.madesub1.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
        val movieId: String,
        val title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val backdrop_path: String,
        val release_date: String,
        val vote_average: Double,
        val isFavorite: Boolean
) : Parcelable
