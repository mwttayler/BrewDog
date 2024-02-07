package com.punk.beers.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.punk.beers.presentation.screens.BeersScreen
import com.punk.beers.presentation.viewmodel.BeersViewModel

object BeersNavigation {

    private const val BEERS_ROUTE = "BEERS_ROUTE"

    fun composeBeersScreen(builder: NavGraphBuilder, onBeerClicked: (id: Int) -> Unit) {
        builder.composable(BEERS_ROUTE) {
            val viewModel = hiltViewModel<BeersViewModel>()
            BeersScreen(viewModel = viewModel, onBeerClicked = onBeerClicked)
        }
    }

    fun buildRoute() = BEERS_ROUTE
}
