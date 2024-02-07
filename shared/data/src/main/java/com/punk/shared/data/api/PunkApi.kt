package com.punk.shared.data.api

import com.punk.shared.data.envelope.BeerEnvelope
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PunkApi {

    @GET("beers")
    suspend fun getBeers(): List<BeerEnvelope>

    @GET("beers/{id}")
    suspend fun getBeer(@Path("id") id: Int): List<BeerEnvelope>
}