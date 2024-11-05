package com.example.group2_oasis_finalproject

import androidx.compose.ui.graphics.vector.ImageVector

data class MyNavItem (
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val route: String
)