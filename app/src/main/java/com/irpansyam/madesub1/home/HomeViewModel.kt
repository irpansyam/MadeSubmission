package com.irpansyam.madesub1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.irpansyam.madesub1.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {

   val movie = movieUseCase.getAllMovie().asLiveData()
}