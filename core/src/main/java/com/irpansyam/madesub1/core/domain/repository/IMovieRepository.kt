package com.irpansyam.madesub1.core.domain.repository

import com.irpansyam.madesub1.core.data.Resource
import com.irpansyam.madesub1.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}