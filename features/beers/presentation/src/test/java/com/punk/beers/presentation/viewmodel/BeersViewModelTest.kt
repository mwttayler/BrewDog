package com.punk.beers.presentation.viewmodel

import app.cash.turbine.test
import com.punk.beers.data.model.Beer
import com.punk.beers.data.repository.BeersRepository
import com.punk.beers.presentation.factory.BeerFactory
import com.punk.beers.presentation.state.BeersViewState
import com.punk.shared.threading.test.MainCoroutineRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeoutException

class BeersViewModelTest {

    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    private lateinit var viewModel: BeersViewModel

    @Test
    fun `GIVEN fetch delay WHEN view model initialized THEN emit loading and success`() = runTest {
        // GIVEN
        val delay = 1L
        val beers = List(size = 20) { BeerFactory.create() }
        val repository = object : BeersRepository {
            override suspend fun fetch(): List<Beer> {
                delay(timeMillis = delay)
                return beers
            }
        }

        // WHEN
        viewModel = BeersViewModel(repository = repository)

        // THEN
        viewModel.viewState.test {
            assertEquals(BeersViewState.Loading, awaitItem())
            assertEquals(BeersViewState.Success(beers), awaitItem())
        }
    }

    @Test
    fun `GIVEN fetch error WHEN view model initialized THEN emit loading and error`() = runTest {
        // GIVEN
        val delay = 1L
        val exception = TimeoutException()
        val repository = object : BeersRepository {
            override suspend fun fetch(): List<Beer> {
                delay(timeMillis = delay)
                throw exception
            }
        }

        // WHEN
        viewModel = BeersViewModel(repository = repository)

        // THEN
        viewModel.viewState.test {
            assertEquals(BeersViewState.Loading, awaitItem())
            assertEquals(BeersViewState.Error(exception), awaitItem())
        }
    }
}
