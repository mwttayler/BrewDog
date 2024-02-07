package com.punk.details.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.punk.details.data.repository.DetailsRepository
import com.punk.details.presentation.navigation.BEER_ID
import com.punk.details.presentation.state.DetailsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: DetailsRepository
) : ViewModel() {

    private val beerId = requireNotNull(savedStateHandle.get<Int>(BEER_ID))

    private val _viewState = MutableStateFlow<DetailsViewState>(DetailsViewState.Loading)
    val viewState: StateFlow<DetailsViewState> = _viewState

    init {
        fetchDetails()
    }

    fun onTryAgainClicked() {
        fetchDetails()
    }

    private fun fetchDetails() {
        viewModelScope.launch {
            _viewState.emit(DetailsViewState.Loading)
            try {
                _viewState.emit(DetailsViewState.Success(repository.fetch(beerId)))
            } catch (throwable: Exception) {
                _viewState.emit(DetailsViewState.Error(throwable))
            }
        }
    }
}
