package com.punk.details.data.factory

import com.punk.shared.data.envelope.MaltEnvelope

object MaltEnvelopeFactory {

    fun create() = MaltEnvelope(
        amount = AmountEnvelopeFactory.create(),
        name = "name"
    )
}
