package com.punk.details.data.mapper

import com.punk.details.data.factory.HopsEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class HopsMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = HopsEnvelopeFactory.create()

        // WHEN
        val actual = HopsMapper.mapFrom(envelope)

        // THEN
        assertEquals(requireNotNull(envelope.name), actual.name)
        assertEquals(AmountMapper.mapFrom(requireNotNull(envelope.amount)), actual.amount)
        assertEquals(requireNotNull(envelope.add), actual.add)
        assertEquals(requireNotNull(envelope.attribute), actual.attribute)
    }
}
