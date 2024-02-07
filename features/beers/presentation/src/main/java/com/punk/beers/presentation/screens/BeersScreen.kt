package com.punk.beers.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.punk.beers.presentation.components.BeerCard
import com.punk.beers.presentation.components.BeerCardPlaceholder
import com.punk.beers.presentation.components.BillboardBeerCard
import com.punk.beers.presentation.components.BillboardBeerCardPlaceholder
import com.punk.beers.presentation.previews.BeersViewStatePreviewParameterProvider
import com.punk.beers.presentation.state.BeersViewState
import com.punk.beers.presentation.viewmodel.BeersViewModel
import com.punk.design.system.PunkTheme
import com.punk.design.system.components.ErrorWithTryAgain
import com.punk.shared.design.system.R as sharedR

@Composable
fun BeersScreen(viewModel: BeersViewModel, onBeerClicked: (id: Int) -> Unit) {
    val viewState by viewModel.viewState.collectAsState()
    BeersScreen(
        viewState = viewState,
        onBeerClicked = onBeerClicked,
        onTryAgainClicked = viewModel::onTryAgainClicked
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeersScreen(
    viewState: BeersViewState,
    onBeerClicked: (id: Int) -> Unit,
    onTryAgainClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = stringResource(id = sharedR.string.app_name)) })
        val state = rememberLazyListState()
        LazyColumn(
            state = state,
            contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            content = {
                when (viewState) {
                    is BeersViewState.Loading -> {
                        items(count = 10) { index ->
                            if (index == 0) {
                                BillboardBeerCardPlaceholder()
                            } else {
                                BeerCardPlaceholder()
                            }
                        }
                    }

                    is BeersViewState.Success -> {
                        itemsIndexed(viewState.beers) { index, beer ->
                            if (index == 0) {
                                BillboardBeerCard(
                                    beer = beer,
                                    modifier = Modifier.clickable { onBeerClicked.invoke(beer.id) }
                                )
                            } else {
                                BeerCard(
                                    beer = beer,
                                    modifier = Modifier.clickable { onBeerClicked.invoke(beer.id) }
                                )
                            }
                        }
                    }

                    is BeersViewState.Error -> {
                        item {
                            ErrorWithTryAgain(
                                throwable = viewState.throwable,
                                onTryAgainClicked = onTryAgainClicked,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun BeersScreenPreview(
    @PreviewParameter(BeersViewStatePreviewParameterProvider::class) viewState: BeersViewState
) {
    PunkTheme {
        BeersScreen(
            viewState = viewState,
            onBeerClicked = { /* no-op */ },
            onTryAgainClicked = { /* no-op */ },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
