package com.punk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.punk.beers.presentation.navigation.BeersNavigation
import com.punk.design.system.PunkTheme
import com.punk.details.presentation.navigation.DetailsNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PunkTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = BeersNavigation.buildRoute()
                    ) {
                        BeersNavigation.composeBeersScreen(
                            builder = this,
                            onBeerClicked = { id ->
                                navController.navigate(DetailsNavigation.buildRoute(id))
                            }
                        )
                        DetailsNavigation.composeDetailsScreen(builder = this)
                    }
                }
            }
        }
    }
}
