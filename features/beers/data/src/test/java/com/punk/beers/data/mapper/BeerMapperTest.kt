package com.punk.beers.data.mapper

import com.punk.beers.data.factory.BeerEnvelopeFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class BeerMapperTest {

    @Test
    fun `GIVEN envelope WHEN mapping THEN verify values`() {
        // GIVEN
        val envelope = BeerEnvelopeFactory.create()

        // WHEN
        val actual = BeerMapper.mapFrom(envelope)

        // THEN
        assertEquals(requireNotNull(envelope.id), actual.id)
        assertEquals(envelope.imageUrl, actual.imageUrl)
        assertEquals(requireNotNull(envelope.name), actual.name)
        assertEquals(envelope.description, actual.description)
    }
}
