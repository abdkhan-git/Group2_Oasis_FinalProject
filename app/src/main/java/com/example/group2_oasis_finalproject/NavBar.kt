package com.example.group2_oasis_finalproject

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navBar() {
    val Context = LocalContext.current
    val navController = rememberNavController()


    val navItemsList = listOf(
        MyNavItem(title = "Main Menu",iconSelected = Icons.Filled.Home, iconUnselected = Icons.Outlined.Home, route = "MainMenuScreen"),
        MyNavItem(title = "Registration", iconSelected = Icons.Filled.Face, iconUnselected = Icons.Outlined.Face, route = "RegistrationScreen"),
        MyNavItem(title = "Student Records", iconSelected = Icons.Filled.Edit, iconUnselected = Icons.Outlined.Edit, route = "StudentRecordsScreen"),
        MyNavItem(title = "Personal Information", iconSelected = Icons.Filled.AccountBox, iconUnselected = Icons.Outlined.AccountBox, route = "PersonalInformationScreen"),
        MyNavItem(title = "financial Information", iconSelected = Icons.Filled.Info, iconUnselected = Icons.Outlined.Info, route = "FinancialInformationScreen"),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    var shownavbar by rememberSaveable { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }
    var Screentitle by rememberSaveable { mutableStateOf("") }



    Scaffold(
        topBar =  {
            if (shownavbar) {
                CenterAlignedTopAppBar (
            title = { Text(text = "${Screentitle}") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = { Toast.makeText(Context, "Navigation Icon Was Pressed", Toast.LENGTH_LONG).show() }) {
                    Icon(ImageVector.vectorResource(id = R.drawable.fsc) , "FSC",Modifier.fillMaxSize())
                } // end - IconButton
            }, // end - navigationIcon
            actions = {
                IconButton(onClick = { showMenu = !showMenu }) { Icon(Icons.Default.AccountCircle, contentDescription = null) }
                DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                    DropdownMenuItem(
                        text= { Text("Favorites") },
                        onClick = {
                            Toast.makeText(Context, "Favorites Action Was Pressed", Toast.LENGTH_LONG).show()
                            showMenu = false
                        },
                        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = null) })
                    DropdownMenuItem(
                        text= { Text("Search") },
                        onClick = {
                            Toast.makeText(Context, "Search Action Was Pressed", Toast.LENGTH_LONG).show()
                            showMenu = false
                        },
                        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) })
                } // end - DropdownMenu
            } // end - actions
        )}},
        bottomBar = {
            if (shownavbar) {
                NavigationBar(containerColor = com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen) {
                    navItemsList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = (selectedItemIndex == index),
                            onClick = {
                                selectedItemIndex = index
                                Toast.makeText(Context, item.title, Toast.LENGTH_SHORT).show()
                                navController.navigate(item.route)
                            },
                            label = { Text(text = item.title) },
                            colors = NavigationBarItemColors(Color.White,Color.White,Color.Transparent,Color.White,Color.White,Color.White,Color.White),
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
                    Screentitle = "Main Menu"
                    shownavbar = true
                    selectedItemIndex = 0
                    mainmenuscreen(navController)
                }//End of composable
                composable(route = "signUpScreen") {
                    signUpScreen(navController)
                }//End of composable
                composable(route = "RegistrationScreen") {
                    Screentitle = "Registration"
                    selectedItemIndex = 1
                    registrationscreen(navController)
                }//End of composable
                composable(route = "StudentRecordsScreen") {
                    Screentitle = "Student Records"
                    selectedItemIndex = 2
                    studentrecordsscreen(navController)
                }//End of composable
                composable(route = "PersonalInformationScreen") {
                    Screentitle = "Personal Information"
                    selectedItemIndex = 3
                    personalinformationscreen(navController)
                }//End of composable
                composable(route = "FinancialInformationScreen") {
                    Screentitle = "Financial Information"
                    selectedItemIndex = 4
                    financialinformationscreen(navController)
                }//End of composable
            }//End of Navhost
            // If not using NavHost, put the main screen's composable here instead
        }//Wnd of Column
    }//End of Scafolld Body
}