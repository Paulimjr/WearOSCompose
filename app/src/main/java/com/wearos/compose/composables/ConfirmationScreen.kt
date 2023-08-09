package com.wearos.compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Confirmation
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.wearos.compose.R

@Composable
fun ConfirmationScreen(navController: NavHostController) {
    Confirmation(
        onTimeout = navController::popBackStack,
        icon = {
            Image(
                painterResource(id = R.drawable.done),
                modifier = Modifier.size(48.dp),
                contentDescription = "confirmation",
            )
        },
        durationMillis = 1300L,
    ) {
        Text(
            text = "Success!",
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultConfirmationPreviewRounded() {
    ConfirmationScreen(rememberSwipeDismissableNavController())
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun DefaultConfirmationPreviewSquare() {
    ConfirmationScreen(rememberSwipeDismissableNavController())
}