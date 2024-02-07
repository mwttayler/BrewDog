package com.punk.details.data.mapper

import com.punk.details.data.model.Details
import com.punk.shared.data.envelope.BeerEnvelope

internal object DetailsMapper {

    fun mapFrom(beer: BeerEnvelope): Details {
        return Details(
            imageUrl = beer.imageUrl,
            name = requireNotNull(beer.name),
            description = requireNotNull(beer.description),
            ingredients = beer.ingredients?.let(IngredientsMapper::mapFrom)
        )
    }
}
