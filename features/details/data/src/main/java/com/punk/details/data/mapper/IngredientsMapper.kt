package com.punk.details.data.mapper

import com.punk.details.data.model.Ingredients
import com.punk.shared.data.envelope.IngredientsEnvelope

internal object IngredientsMapper {

    fun mapFrom(ingredients: IngredientsEnvelope): Ingredients {
        return Ingredients(
            hops = ingredients.hops?.map(HopsMapper::mapFrom),
            malt = ingredients.malt?.map(MaltMapper::mapFrom),
            yeast = ingredients.yeast
        )
    }
}
