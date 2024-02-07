package com.punk.details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.punk.design.system.PunkTheme
import com.punk.details.data.model.Details
import com.punk.details.data.model.Malt
import com.punk.details.presentation.components.formatter.UnitFormatter
import com.punk.details.presentation.previews.DetailsPreviewParameterProvider

@Composable
fun MaltRow(malt: Malt, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(
            text = malt.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1F)
        )
        val unit = UnitFormatter.format(
            resources = LocalContext.current.resources,
            unit = malt.amount.unit
        )
        Text(
            text = "${malt.amount.value}$unit",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1.5F)
        )
    }
}

@Preview
@Composable
private fun MaltRowPreview(
    @PreviewParameter(DetailsPreviewParameterProvider::class) details: Details
) {
    PunkTheme {
        MaltRow(
            malt = details.ingredients!!.malt!!.first(),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
