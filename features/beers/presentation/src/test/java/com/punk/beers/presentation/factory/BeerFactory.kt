package com.punk.beers.presentation.factory

import com.punk.beers.data.model.Beer

object BeerFactory {

    fun create() = Beer(
        id = 1,
        imageUrl = "imageUrl",
        name = "name",
        description = "description"
    )
}
