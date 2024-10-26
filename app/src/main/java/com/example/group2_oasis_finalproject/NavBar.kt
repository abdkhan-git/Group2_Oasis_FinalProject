package com.example.group2_oasis_finalproject

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navBar() {
    val Context = LocalContext.current
    val navController = rememberNavController()


    val navItemsList = listOf(
        MyNavItem(title = "MainMenu",iconSelected = Icons.Filled.Home, iconUnselected = Icons.Outlined.Home, route = "MainMenuScreen"),
        MyNavItem(title = "Registration", iconSelected = Icons.Filled.Face, iconUnselected = Icons.Outlined.Face, route = "RegistrationScreen"),
        MyNavItem(title = "Student Records", iconSelected = Icons.Filled.Edit, iconUnselected = Icons.Outlined.Edit, route = "StudentRecordsScreen"),
        MyNavItem(title = "Personal Information", iconSelected = Icons.Filled.AccountBox, iconUnselected = Icons.Outlined.AccountBox, route = "PersonalInformationScreen"),
        MyNavItem(title = "financial Information", iconSelected = Icons.Filled.Info, iconUnselected = Icons.Outlined.Info, route = "FinancialInformationScreen"),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    var shownavbar by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (shownavbar) {
                NavigationBar {
                    navItemsList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = (selectedItemIndex == index),
                            onClick = {
                                selectedItemIndex = index
                                Toast.makeText(Context, item.title, Toast.LENGTH_SHORT).show()
                                navController.navigate(item.route)
                            },
                            label = { Text(text = item.title) },
                            icon = { Icon(contentDescription = item.title, imageVector = if (index == selectedItemIndex) item.iconSelected else item.iconUnselected) }//End of Icon
                        )//End of navigation bar item
                    }//End of NavItem List
                }//End of Navigation Bar
            }//End of Bottom Bar
        }//End of IF (NavBar)
    )//End of Scaffold
    { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            // If using a NavHost, put the NavHost composable here
            //navHost(navController)
            NavHost(navController = navController, startDestination = "SignInScreen") {
                composable(route = "SignInScreen") {
                    signinscreen(navController)
                }//End of composable
                composable(route = "MainMenuScreen") {
                    shownavbar = true
                    mainmenuscreen(navController)
                }//End of composable
                composable(route = "RegistrationScreen") {
                    registrationscreen(navController)
                }//End of composable
                composable(route = "StudentRecordsScreen") {
                    studentrecordsscreen(navController)
                }//End of composable
                composable(route = "PersonalInformationScreen") {
                    personalinformationscreen(navController)
                }//End of composable
                composable(route = "FinancialInformationScreen") {
                    financialinformationscreen(navController)
                }//End of composable
            }//End of Navhost
            // If not using NavHost, put the main screen's composable here instead
        }//Wnd of Column
    }//End of Scafolld Body
}