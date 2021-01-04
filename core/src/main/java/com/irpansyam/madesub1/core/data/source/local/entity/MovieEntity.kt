package com.irpansyam.madesub1.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo
    var overview: String,

    @ColumnInfo
    var popularity: Double,

    @ColumnInfo
    var poster_path: String,

    @ColumnInfo
    var backdrop_path: String,

    @ColumnInfo
    var release_date: String,

    @ColumnInfo
    var vote_average: Double,

    @ColumnInfo
    var isFavorite: Boolean = false

)

