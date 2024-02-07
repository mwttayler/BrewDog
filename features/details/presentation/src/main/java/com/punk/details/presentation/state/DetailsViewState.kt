package com.punk.details.presentation.state

import com.punk.details.data.model.Details

sealed interface DetailsViewState {
    data object Loading : DetailsViewState
    data class Success(val details: Details) : DetailsViewState
    data class Error(val throwable: Throwable) : DetailsViewState
}
