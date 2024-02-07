package com.punk.beers.data.mapper

import com.punk.beers.data.model.Beer
import com.punk.shared.data.envelope.BeerEnvelope

object BeerMapper {

    fun mapFrom(beer: BeerEnvelope): Beer {
        return Beer(
            id = requireNotNull(beer.id),
            imageUrl = beer.imageUrl,
            name = requireNotNull(beer.name),
            description = beer.description
        )
    }
}
