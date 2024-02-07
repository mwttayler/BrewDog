package com.punk.beers.data.repository

import com.punk.beers.data.factory.BeerEnvelopeFactory
import com.punk.beers.data.mapper.BeerMapper
import com.punk.shared.data.api.PunkApi
import com.punk.shared.data.envelope.BeerEnvelope
import com.punk.shared.threading.test.MainCoroutineRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BeersRepositoryImplTest {

    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    @Test
    fun `GIVEN api returns list of beers WHEN fetching THEN verify output`() = runTest {
        // GIVEN
        val beers = List(size = 20) { BeerEnvelopeFactory.create() }
        val punkApi = object : PunkApi {
            override suspend fun getBeers(): List<BeerEnvelope> {
                return beers
            }

            override suspend fun getBeer(id: Int): List<BeerEnvelope> {
                throw NotImplementedError("not to be referenced by this test.")
            }
        }
        val repository = BeersRepositoryImpl(
            dispatcherProvider = coroutineTestRule.dispatcherProvider,
            punkApi = punkApi
        )

        // WHEN
        val actual = repository.fetch()

        // THEN
        val expected = beers.map { BeerMapper.mapFrom(it) }
        assertEquals(expected, actual)
    }
}
