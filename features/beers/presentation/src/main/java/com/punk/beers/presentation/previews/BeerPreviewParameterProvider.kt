package com.punk.beers.presentation.previews

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.punk.beers.data.model.Beer

class BeerPreviewParameterProvider : PreviewParameterProvider<Beer> {

    override val values: Sequence<Beer> = sequenceOf(
        Beer(
            id = 0,
            imageUrl = "",
            name = "Beer",
            description = "Beer description here."
        )
    )
}
