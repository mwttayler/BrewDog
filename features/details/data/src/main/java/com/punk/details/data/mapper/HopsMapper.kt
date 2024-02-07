package com.punk.details.data.mapper

import com.punk.details.data.model.Hops
import com.punk.shared.data.envelope.HopsEnvelope

internal object HopsMapper {

    fun mapFrom(hops: HopsEnvelope): Hops {
        return Hops(
            name = requireNotNull(hops.name),
            amount = AmountMapper.mapFrom(requireNotNull(hops.amount)),
            add = requireNotNull(hops.add),
            attribute = requireNotNull(hops.attribute)
        )
    }
}
