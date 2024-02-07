package com.punk.beers.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.material.placeholder
import com.punk.beers.data.model.Beer
import com.punk.beers.presentation.previews.BeerPreviewParameterProvider
import com.punk.design.system.PunkTheme

@Composable
fun BeerCard(beer: Beer, modifier: Modifier = Modifier) {
    BeerCard(
        imageUrl = beer.imageUrl,
        name = beer.name,
        description = beer.description,
        modifier = modifier
    )
}

@Composable
fun BeerCardPlaceholder(modifier: Modifier = Modifier) {
    BeerCard(
        imageUrl = "",
        name = "",
        description = "",
        modifier = modifier.placeholder(
            visible = true,
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

@Composable
private fun BeerCard(
    imageUrl: String?,
    name: String,
    description: String?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(15.dp)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall
            )
            description?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun BeerCardPreview(
    @PreviewParameter(BeerPreviewParameterProvider::class) beer: Beer
) {
    PunkTheme {
        BeerCard(
            beer = beer,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
