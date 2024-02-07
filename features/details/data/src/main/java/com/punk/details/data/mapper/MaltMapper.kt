package com.punk.details.data.mapper

import com.punk.details.data.model.Malt
import com.punk.shared.data.envelope.MaltEnvelope

internal object MaltMapper {

    fun mapFrom(malt: MaltEnvelope): Malt {
        return Malt(
            name = requireNotNull(malt.name),
            amount = AmountMapper.mapFrom(requireNotNull(malt.amount))
        )
    }
}
