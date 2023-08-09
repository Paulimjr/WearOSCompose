package com.wearos.compose.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.wearos.compose.R

@Composable
fun AlertDialogScreen(navController: NavHostController) {
    Alert(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "airplane",
                modifier = Modifier.size(24.dp).wrapContentSize(align = Alignment.Center),
            )
        },
        title = { Text("Alert Title", textAlign = TextAlign.Center) },
        negativeButton = { Button(
            colors = ButtonDefaults.secondaryButtonColors(),
            onClick = {
                navController.popBackStack()
            }) {
            Text("No")
        } },
        positiveButton = { Button(onClick = {
            navController.popBackStack()
        }) { Text("Yes") } },
        contentPadding =
        PaddingValues(start = 10.dp, end = 10.dp, top = 24.dp, bottom = 32.dp),
    ) {
        Text(
            text = "Description...",
            textAlign = TextAlign.Center
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultAlertPreviewRounded() {
    AlertDialogScreen(rememberSwipeDismissableNavController())
}

@Preview(device = Devices.WEAR_OS_SQUARE, showSystemUi = true)
@Composable
fun DefaultAlertPreviewSquare() {
    AlertDialogScreen(rememberSwipeDismissableNavController())
}