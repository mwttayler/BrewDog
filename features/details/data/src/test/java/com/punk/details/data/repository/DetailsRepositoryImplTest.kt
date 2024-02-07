package com.punk.details.data.repository

import com.punk.details.data.factory.BeerEnvelopeFactory
import com.punk.details.data.mapper.DetailsMapper
import com.punk.shared.data.api.PunkApi
import com.punk.shared.data.envelope.BeerEnvelope
import com.punk.shared.threading.test.MainCoroutineRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class DetailsRepositoryImplTest {

    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    @Test
    fun `GIVEN valid json WHEN fetching THEN verify output`() = runTest {
        // GIVEN
        val beerId = 1
        val beers = listOf(BeerEnvelopeFactory.create())
        val punkApi = object : PunkApi {
            override suspend fun getBeers(): List<BeerEnvelope> {
                throw NotImplementedError("not to be referenced by this test.")
            }

            override suspend fun getBeer(id: Int): List<BeerEnvelope> {
                return beers
            }
        }
        val repository = DetailsRepositoryImpl(
            dispatcherProvider = coroutineTestRule.dispatcherProvider,
            punkApi = punkApi
        )

        // WHEN
        val actual = repository.fetch(beerId)

        // THEN
        val expected = DetailsMapper.mapFrom(beers.first())
        assertEquals(expected, actual)
    }
}
