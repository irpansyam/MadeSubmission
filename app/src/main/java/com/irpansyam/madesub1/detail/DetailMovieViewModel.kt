package com.irpansyam.madesub1.detail

import androidx.lifecycle.ViewModel
import com.irpansyam.madesub1.core.domain.model.Movie
import com.irpansyam.madesub1.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) = movieUseCase.setFavoriteMovie(movie, newStatus)
}