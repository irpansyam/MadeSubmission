package com.irpansyam.madesub1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.irpansyam.madesub1.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {

   val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}