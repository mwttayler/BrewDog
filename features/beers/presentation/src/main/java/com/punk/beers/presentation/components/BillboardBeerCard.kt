package com.punk.beers.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
fun BillboardBeerCard(beer: Beer, modifier: Modifier = Modifier) {
    BillboardBeerCard(
        imageUrl = beer.imageUrl,
        name = beer.name,
        description = beer.description,
        modifier = modifier
    )
}

@Composable
fun BillboardBeerCardPlaceholder(modifier: Modifier = Modifier) {
    BillboardBeerCard(
        imageUrl = "",
        name = "",
        description = "",
        modifier = modifier.placeholder(
            visible = true,
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

@Composable
private fun BillboardBeerCard(
    imageUrl: String?,
    name: String,
    description: String?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(ratio = 1.7777778F)
                .verticalGradientOverlay(
                    arrayOf(
                        0F to Color.Transparent,
                        0.75F to MaterialTheme.colorScheme.surfaceVariant,
                        1F to MaterialTheme.colorScheme.surfaceVariant
                    )
                )
                .padding(10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(15.dp)
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            description?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

private fun Modifier.verticalGradientOverlay(
    colorStops: Array<out Pair<Float, Color>>,
    startY: Float = 0F,
    endY: Float = Float.POSITIVE_INFINITY,
    blendMode: BlendMode = BlendMode.SrcOver
): Modifier = this.drawWithCache {
    val gradient = Brush.verticalGradient(
        colorStops = colorStops,
        startY = startY,
        endY = endY
    )
    onDrawWithContent {
        drawContent()
        drawRect(brush = gradient, blendMode = blendMode)
    }
}

@Preview
@Composable
private fun BillboardBeerCardPreview(
    @PreviewParameter(BeerPreviewParameterProvider::class) beer: Beer
) {
    PunkTheme {
        BillboardBeerCard(
            beer = beer,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
