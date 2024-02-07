package com.punk.details.data.factory

import com.punk.shared.data.envelope.IngredientsEnvelope

object IngredientsEnvelopeFactory {

    fun create() = IngredientsEnvelope(
        hops = listOf(HopsEnvelopeFactory.create()),
        malt = listOf(MaltEnvelopeFactory.create()),
        yeast = "yeast"
    )
}
