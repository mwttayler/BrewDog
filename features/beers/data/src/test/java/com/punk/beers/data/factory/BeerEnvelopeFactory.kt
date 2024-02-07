package com.punk.beers.data.factory

import com.punk.shared.data.envelope.AmountEnvelope
import com.punk.shared.data.envelope.BeerEnvelope
import com.punk.shared.data.envelope.BoilVolumeEnvelope
import com.punk.shared.data.envelope.HopsEnvelope
import com.punk.shared.data.envelope.IngredientsEnvelope
import com.punk.shared.data.envelope.MaltEnvelope
import com.punk.shared.data.envelope.MethodEnvelope
import com.punk.shared.data.envelope.VolumeEnvelope

object BeerEnvelopeFactory {

    fun create() = BeerEnvelope(
        abv = 1.0,
        attenuationLevel = 1.0,
        boilVolume = BoilVolumeEnvelope(
            unit = "g",
            value = 10
        ),
        brewersTips = "brewersTips",
        contributedBy = "contributedBy",
        description = "description",
        ebc = 1.0,
        firstBrewed = "firstBrewed",
        foodPairing = listOf("foodPairing"),
        ibu = 1.0,
        id = 1,
        imageUrl = "imageUrl",
        ingredients = IngredientsEnvelope(
            hops = listOf(
                HopsEnvelope(
                    add = "add",
                    amount = AmountEnvelope(unit = "g", value = 1.0),
                    attribute = "attribute",
                    name = "name"
                )
            ),
            malt = listOf(
                MaltEnvelope(
                    amount = AmountEnvelope(unit = "g", value = 1.0),
                    name = "name"
                )
            ),
            yeast = null
        ),
        method = MethodEnvelope(
            fermentation = null,
            mashTemp = listOf()
        ),
        name = "name",
        ph = 1.0,
        srm = 1.0,
        tagline = "tagline",
        targetFg = 1.0,
        targetOg = 1.0,
        volume = VolumeEnvelope(
            unit = "g",
            value = 1
        )
    )
}
