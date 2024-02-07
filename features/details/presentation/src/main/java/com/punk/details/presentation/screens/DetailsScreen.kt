package com.punk.details.presentation.screens

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.material.placeholder
import com.punk.design.system.PunkTheme
import com.punk.design.system.components.ErrorWithTryAgain
import com.punk.details.data.model.Details
import com.punk.details.presentation.components.HopsInformation
import com.punk.details.presentation.components.MaltInformation
import com.punk.details.presentation.components.YeastInformation
import com.punk.details.presentation.previews.DetailsPreviewParameterProvider
import com.punk.details.presentation.state.DetailsViewState
import com.punk.details.presentation.viewmodel.DetailsViewModel
import com.punk.shared.design.system.R as sharedR

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val viewState by viewModel.viewState.collectAsState()
    DetailsScreen(viewState = viewState, onTryAgainClicked = viewModel::onTryAgainClicked)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    viewState: DetailsViewState,
    onTryAgainClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = { /* no-op */ },
            navigationIcon = {
                IconButton(onClick = { backPressedDispatcher?.onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        )
        Box(modifier = Modifier.padding(15.dp)) {
            when (viewState) {
                is DetailsViewState.Loading -> {
                    Loading()
                }

                is DetailsViewState.Success -> {
                    Success(details = viewState.details)
                }

                is DetailsViewState.Error -> {
                    ErrorWithTryAgain(
                        throwable = viewState.throwable,
                        onTryAgainClicked = onTryAgainClicked,
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .placeholder(
                    visible = true,
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                .aspectRatio(ratio = 1.33F)
        )
    }
}

@Composable
private fun Success(details: Details, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = details.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .aspectRatio(ratio = 1.33F)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(vertical = 15.dp)
        )
        Text(
            text = details.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = details.description,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = stringResource(id = sharedR.string.details_ingredients_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium
        )
        details.ingredients?.hops?.let { HopsInformation(hops = it) }
        details.ingredients?.malt?.let { MaltInformation(malt = it) }
        details.ingredients?.yeast?.let { YeastInformation(yeast = it) }
    }
}

@Preview
@Composable
private fun DetailsScreenPreview(
    @PreviewParameter(DetailsPreviewParameterProvider::class) viewState: DetailsViewState
) {
    PunkTheme {
        DetailsScreen(
            viewState = viewState,
            onTryAgainClicked = { /* no-op */ },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
