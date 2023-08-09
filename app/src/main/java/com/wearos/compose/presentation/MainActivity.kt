package com.wearos.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.wearos.compose.composables.AlertDialogScreen
import com.wearos.compose.composables.CardsScreen
import com.wearos.compose.composables.ConfirmationScreen
import com.wearos.compose.composables.HomeScreen
import com.wearos.compose.destinations.Destinations
import com.wearos.compose.presentation.theme.WearOSComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WearApp() }
    }
}

@Composable
fun WearApp() {
    WearOSComposeTheme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                if (!listState.isScrollInProgress) { // Condition to hide Time Text while we are scrolling
                    TimeText()
                }
            },
            positionIndicator = {
                PositionIndicator(scalingLazyListState = listState)
            }
        ) {
            MainContent(listState)
        }
    }
}

@Composable
private fun MainContent(listState: ScalingLazyListState) {
    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Destinations.Home.route,
    ) {
        composable(route = Destinations.Home.route) {
            HomeScreen(navController = navController, listState)
        }
        composable(route = Destinations.AlertDialog.route) {
            AlertDialogScreen(navController = navController)
        }
        composable(route = Destinations.Confirmation.route) {
            ConfirmationScreen(navController = navController)
        }
        composable(route = Destinations.Cards.route) {
            CardsScreen()
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreviewRounded() {
    WearApp()
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun DefaultPreviewSquare() {
    WearApp()
}