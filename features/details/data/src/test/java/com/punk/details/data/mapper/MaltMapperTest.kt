package com.punk.details.data.mapper

import com.punk.details.data.factory.MaltEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class MaltMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = MaltEnvelopeFactory.create()

        // WHEN
        val actual = MaltMapper.mapFrom(envelope)

        // THEN
        assertEquals(requireNotNull(envelope.name), actual.name)
        assertEquals(AmountMapper.mapFrom(requireNotNull(envelope.amount)), actual.amount)
    }
}
