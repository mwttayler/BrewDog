package com.punk.details.data.mapper

import com.punk.details.data.model.Amount
import com.punk.shared.data.envelope.AmountEnvelope

internal object AmountMapper {

    fun mapFrom(malt: AmountEnvelope): Amount {
        return Amount(
            value = requireNotNull(malt.value),
            unit = requireNotNull(malt.unit)
        )
    }
}
