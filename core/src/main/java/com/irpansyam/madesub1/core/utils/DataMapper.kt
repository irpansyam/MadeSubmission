package com.irpansyam.madesub1.core.utils

import com.irpansyam.madesub1.core.data.source.local.entity.MovieEntity
import com.irpansyam.madesub1.core.data.source.remote.response.MovieResponse
import com.irpansyam.madesub1.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.movieId,
                title = it.title,
                overview =  it.overview,
                popularity = it.popularity,
                poster_path = it.poster_path,
                backdrop_path = it.backdrop_path,
                release_date = it.release_date,
                vote_average = it.vote_average,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
            input.map {
                Movie(
                        movieId = it.movieId,
                        title = it.title,
                        overview = it.overview,
                        popularity = it.popularity,
                        poster_path = it.poster_path,
                        backdrop_path = it.backdrop_path,
                        release_date = it.release_date,
                        vote_average = it.vote_average,
                        isFavorite = it.isFavorite

                )
            }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
            movieId = input.movieId,
            title = input.title,
            overview = input.overview,
            popularity = input.popularity,
            poster_path = input.poster_path,
            backdrop_path = input.backdrop_path,
            release_date = input.release_date,
            vote_average = input.vote_average,
            isFavorite = input.isFavorite
    )
}