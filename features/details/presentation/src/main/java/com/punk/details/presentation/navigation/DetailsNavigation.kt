package com.punk.details.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.punk.details.presentation.screens.DetailsScreen

internal const val BEER_ID = "beer_id"
private const val DETAILS_ROUTE_PREFIX = "DETAILS_ROUTE/"
private const val DETAILS_ROUTE = "$DETAILS_ROUTE_PREFIX{$BEER_ID}"

object DetailsNavigation {

    fun composeDetailsScreen(builder: NavGraphBuilder) {
        builder.composable(
            route = DETAILS_ROUTE,
            arguments = listOf(navArgument(BEER_ID) { type = NavType.IntType })
        ) {
            DetailsScreen(viewModel = hiltViewModel(it))
        }
    }

    fun buildRoute(id: Int) = "$DETAILS_ROUTE_PREFIX$id"
}
