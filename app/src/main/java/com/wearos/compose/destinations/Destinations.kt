package com.wearos.compose.destinations

sealed class Destinations(val route: String) {
    object Home : Destinations("home")
    object AlertDialog : Destinations("alert")
    object Confirmation : Destinations("confirmation")
    object Cards : Destinations("cards")
}
