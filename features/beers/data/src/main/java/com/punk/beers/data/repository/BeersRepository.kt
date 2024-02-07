package com.punk.beers.data.repository

import com.punk.beers.data.model.Beer

interface BeersRepository {
    suspend fun fetch(): List<Beer>
}
