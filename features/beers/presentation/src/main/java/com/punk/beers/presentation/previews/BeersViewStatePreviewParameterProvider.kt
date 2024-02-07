package com.punk.beers.presentation.previews

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.punk.beers.data.model.Beer
import com.punk.beers.presentation.state.BeersViewState
import java.lang.RuntimeException

class BeersViewStatePreviewParameterProvider : PreviewParameterProvider<BeersViewState> {

    private val beers = List(size = 20) { index ->
        Beer(
            id = index,
            imageUrl = "",
            name = "Beer $index",
            description = "Beer description here."
        )
    }
    override val values: Sequence<BeersViewState> = sequenceOf(
        BeersViewState.Loading,
        BeersViewState.Success(beers),
        BeersViewState.Error(RuntimeException())
    )
}
