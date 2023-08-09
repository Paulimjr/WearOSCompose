package com.wearos.compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.Text
import com.wearos.compose.R
import com.wearos.compose.destinations.Destinations


@Composable
fun HomeScreen(navController: NavHostController, listState: ScalingLazyListState) {
    ScalingLazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        item { ListHeader { Text(stringResource(id = R.string.title_list)) } }

        item {
            Chip(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destinations.AlertDialog.route) },
                label = { Text("Open Alert") },
                colors = ChipDefaults.secondaryChipColors()
            )
        }
        item {
            Chip(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destinations.Confirmation.route) },
                label = { Text("Open Confirmation") },
                colors = ChipDefaults.secondaryChipColors()
            )
        }
        item {
            Chip(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destinations.Cards.route) },
                label = { Text("Open Cards") },
                colors = ChipDefaults.secondaryChipColors()
            )
        }
    }
}

