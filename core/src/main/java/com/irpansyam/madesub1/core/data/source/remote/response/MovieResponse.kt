package com.irpansyam.madesub1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("id")
    val movieId: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("poster_path")
    val poster_path: String,

    @field:SerializedName("backdrop_path")
    val backdrop_path: String,

    @field:SerializedName("release_date")
    val release_date: String,

    @field:SerializedName("vote_average")
    val vote_average: Double
)
