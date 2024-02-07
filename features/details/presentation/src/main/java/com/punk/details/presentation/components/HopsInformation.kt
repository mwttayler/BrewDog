package com.punk.details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.punk.design.system.PunkTheme
import com.punk.details.data.model.Details
import com.punk.details.data.model.Hops
import com.punk.details.presentation.previews.DetailsPreviewParameterProvider
import com.punk.shared.design.system.R as sharedR

@Composable
fun HopsInformation(hops: List<Hops>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = sharedR.string.details_hops_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(5.dp))
        hops.forEach { HopRow(hop = it) }
    }
}

@Preview
@Composable
private fun HopsInformationPreview(
    @PreviewParameter(DetailsPreviewParameterProvider::class) details: Details
) {
    PunkTheme {
        HopsInformation(
            hops = details.ingredients!!.hops!!,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
