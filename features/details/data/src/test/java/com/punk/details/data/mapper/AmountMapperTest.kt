package com.punk.details.data.mapper

import com.punk.details.data.factory.AmountEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class AmountMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = AmountEnvelopeFactory.create()

        // WHEN
        val actual = AmountMapper.mapFrom(envelope)

        // THEN
        assertEquals(requireNotNull(envelope.value), actual.value, 0.0)
        assertEquals(requireNotNull(envelope.unit), actual.unit)
    }
}
