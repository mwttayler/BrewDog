package com.punk.beers.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.punk.beers.data.repository.BeersRepository
import com.punk.beers.presentation.state.BeersViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    private val repository: BeersRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow<BeersViewState>(BeersViewState.Loading)
    val viewState: StateFlow<BeersViewState> = _viewState

    init {
        fetchBeers()
    }

    fun onTryAgainClicked() {
        fetchBeers()
    }

    private fun fetchBeers() {
        viewModelScope.launch {
            _viewState.emit(BeersViewState.Loading)
            try {
                _viewState.emit(BeersViewState.Success(repository.fetch()))
            } catch (throwable: Exception) {
                _viewState.emit(BeersViewState.Error(throwable))
            }
        }
    }
}
