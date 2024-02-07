package com.punk.beers.presentation.state

import com.punk.beers.data.model.Beer

sealed interface BeersViewState {
    data object Loading : BeersViewState
    data class Success(val beers: List<Beer>) : BeersViewState
    data class Error(val throwable: Throwable) : BeersViewState
}
