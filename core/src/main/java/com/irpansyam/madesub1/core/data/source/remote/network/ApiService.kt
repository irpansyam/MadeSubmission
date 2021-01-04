package com.irpansyam.madesub1.core.data.source.remote.network

import com.irpansyam.madesub1.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("popular?api_key=fdbaaf168954fe6ee2b574fb4522d0f9&language=en-US&page=1")
    suspend fun getList(): ListMovieResponse

}