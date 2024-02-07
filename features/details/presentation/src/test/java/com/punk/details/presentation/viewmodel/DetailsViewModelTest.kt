package com.punk.details.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.punk.details.data.model.Details
import com.punk.details.data.repository.DetailsRepository
import com.punk.details.presentation.factory.DetailsEntityFactory
import com.punk.details.presentation.navigation.BEER_ID
import com.punk.details.presentation.state.DetailsViewState
import com.punk.shared.threading.test.MainCoroutineRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeoutException

class DetailsViewModelTest {

    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    private val beerId = 1
    private val savedStateHandle = SavedStateHandle().apply { set(BEER_ID, beerId) }
    private lateinit var viewModel: DetailsViewModel

    @Test
    fun `GIVEN fetch delay WHEN view model initialized THEN emit loading and success`() = runTest {
        // GIVEN
        val delay = 1L
        val details = DetailsEntityFactory.create()
        val repository = object : DetailsRepository {
            override suspend fun fetch(id: Int): Details {
                delay(timeMillis = delay)
                return details
            }
        }

        // WHEN
        viewModel = DetailsViewModel(
            savedStateHandle = savedStateHandle,
            repository = repository
        )

        // THEN
        viewModel.viewState.test {
            assertEquals(DetailsViewState.Loading, awaitItem())
            assertEquals(DetailsViewState.Success(details), awaitItem())
        }
    }

    @Test
    fun `GIVEN fetch error WHEN view model initialized THEN emit loading and error`() = runTest {
        // GIVEN
        val delay = 1L
        val exception = TimeoutException()
        val repository = object : DetailsRepository {
            override suspend fun fetch(id: Int): Details {
                delay(timeMillis = delay)
                throw exception
            }
        }

        // WHEN
        viewModel = DetailsViewModel(
            savedStateHandle = savedStateHandle,
            repository = repository
        )

        // THEN
        viewModel.viewState.test {
            assertEquals(DetailsViewState.Loading, awaitItem())
            assertEquals(DetailsViewState.Error(exception), awaitItem())
        }
    }
}
