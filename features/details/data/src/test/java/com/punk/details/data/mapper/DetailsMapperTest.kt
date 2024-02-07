package com.punk.details.data.mapper

import com.punk.details.data.factory.BeerEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class DetailsMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = BeerEnvelopeFactory.create()

        // WHEN
        val actual = DetailsMapper.mapFrom(envelope)

        // THEN
        assertEquals(envelope.imageUrl, actual.imageUrl)
        assertEquals(requireNotNull(envelope.name), actual.name)
        assertEquals(requireNotNull(envelope.description), actual.description)
        assertEquals(envelope.ingredients?.let(IngredientsMapper::mapFrom), actual.ingredients)
    }
}
