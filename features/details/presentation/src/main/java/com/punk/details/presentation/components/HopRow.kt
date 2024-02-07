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
import com.punk.details.data.model.Hops
import com.punk.details.presentation.components.formatter.UnitFormatter
import com.punk.details.presentation.previews.DetailsPreviewParameterProvider

@Composable
fun HopRow(hop: Hops, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(
            text = hop.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1F)
        )
        val unit = UnitFormatter.format(
            resources = LocalContext.current.resources,
            unit = hop.amount.unit
        )
        Text(
            text = "${hop.amount.value}$unit",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(0.5F)
        )
        Text(
            text = hop.add.replaceFirstChar(Char::titlecase),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(0.5F)
        )
        Text(
            text = hop.attribute.replaceFirstChar(Char::titlecase),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(0.5F)
        )
    }
}

@Preview
@Composable
private fun HopRowPreview(
    @PreviewParameter(DetailsPreviewParameterProvider::class) details: Details
) {
    PunkTheme {
        HopRow(
            hop = details.ingredients!!.hops!!.first(),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
