package com.punk.details.data.factory

import com.punk.shared.data.envelope.HopsEnvelope

object HopsEnvelopeFactory {

    fun create() = HopsEnvelope(
        add = "add",
        amount = AmountEnvelopeFactory.create(),
        attribute = "attribute",
        name = "name"
    )
}
