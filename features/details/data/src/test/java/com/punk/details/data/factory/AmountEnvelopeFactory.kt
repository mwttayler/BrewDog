package com.punk.details.data.factory

import com.punk.shared.data.envelope.AmountEnvelope

object AmountEnvelopeFactory {

    fun create() = AmountEnvelope(unit = "g", value = 1.0)
}
