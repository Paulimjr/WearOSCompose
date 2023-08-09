package com.wearos.compose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController

@Composable
fun CardsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppCard(
            modifier = modifier.padding(all = 12.dp),
            onClick = { /*TODO*/ },
            appImage = {
                Icon(
                    imageVector = Icons.Rounded.AccountBox,
                    contentDescription = "",
                    modifier = modifier,
                )
            },
            appName = { Text(text = "Message Test") },
            time = { Text(text = "12m") },
            title = { Text(text = "Paulo Cesar") }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Testing...")
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
private fun DefaultCardsPreviewRounded() {
    CardsScreen()
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
private fun DefaultCardsPreviewSquare() {
    CardsScreen()
}