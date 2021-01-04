package com.irpansyam.madesub1.di

import com.irpansyam.madesub1.core.domain.usecase.MovieInteractor
import com.irpansyam.madesub1.core.domain.usecase.MovieUseCase
import com.irpansyam.madesub1.detail.DetailMovieViewModel
import com.irpansyam.madesub1.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get())}
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}