package com.punk.details.data.mapper

import com.punk.details.data.factory.IngredientsEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class IngredientsMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = IngredientsEnvelopeFactory.create()

        // WHEN
        val actual = IngredientsMapper.mapFrom(envelope)

        // THEN
        assertEquals(envelope.hops?.map(HopsMapper::mapFrom), actual.hops)
        assertEquals(envelope.malt?.map(MaltMapper::mapFrom), actual.malt)
        assertEquals(envelope.yeast, actual.yeast)
    }
}
