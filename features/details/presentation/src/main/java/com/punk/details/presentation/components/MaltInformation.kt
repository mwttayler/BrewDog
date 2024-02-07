
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
import com.punk.details.data.model.Malt
import com.punk.details.presentation.previews.DetailsPreviewParameterProvider
import com.punk.shared.design.system.R as sharedR

@Composable
fun MaltInformation(malt: List<Malt>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = sharedR.string.details_malt_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(5.dp))
        malt.forEach { MaltRow(malt = it) }
    }
}

@Preview
@Composable
private fun MaltInformationPreview(
    @PreviewParameter(DetailsPreviewParameterProvider::class) details: Details
) {
    PunkTheme {
        MaltInformation(
            malt = details.ingredients!!.malt!!,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
