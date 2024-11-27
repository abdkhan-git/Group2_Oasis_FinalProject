package com.example.group2_oasis_finalproject

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navBar(navController: NavController, viewModel: MainMenuScreenViewModel) {
    val Context = LocalContext.current
    val navController = rememberNavController()

    val navItemsList = listOf(
        MyNavItem(title = "Main Menu",iconSelected = Icons.Filled.Home, iconUnselected = Icons.Outlined.Home, route = "MainMenuScreen"),
        MyNavItem(title = "Registration", iconSelected = Icons.Filled.Face, iconUnselected = Icons.Outlined.Face, route = "RegistrationScreen"),
        MyNavItem(title = "Student Records", iconSelected = Icons.Filled.Edit, iconUnselected = Icons.Outlined.Edit, route = "StudentRecordsScreen"),
        MyNavItem(title = "Personal Information", iconSelected = Icons.Filled.AccountBox, iconUnselected = Icons.Outlined.AccountBox, route = "PersonalInformationScreen"),
        MyNavItem(title = "Financial Information", iconSelected = Icons.Filled.Info, iconUnselected = Icons.Outlined.Info, route = "FinancialInformationScreen"),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    var shownavbar by rememberSaveable { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }
    var Screentitle by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            if (shownavbar) {
                CenterAlignedTopAppBar(
                    title = { Text(text = "${Screentitle}") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = FarmingdaleGreen,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            val webpage: Uri = Uri.parse("https://www.farmingdale.edu/")
                            val intent = Intent(Intent.ACTION_VIEW, webpage)
                            Toast.makeText(Context, "Navigating to Farmingdale Home Page", Toast.LENGTH_LONG).show()
                            Context.startActivity(intent)
                        }) {
                            Icon(ImageVector.vectorResource(id = R.drawable.fsc), "FSC", Modifier.fillMaxSize())
                        }
                    },
                    actions = {
                        IconButton(onClick = { showMenu = !showMenu }) { Icon(Icons.Default.AccountCircle, contentDescription = null) }
                        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                            DropdownMenuItem(
                                text = { Text("Favorites") },
                                onClick = {
                                    Toast.makeText(Context, "Favorites Action Was Pressed", Toast.LENGTH_LONG).show()
                                    showMenu = false
                                },
                                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = null) }
                            )
                            DropdownMenuItem(
                                text = { Text("Search") },
                                onClick = {
                                    Toast.makeText(Context, "Search Action Was Pressed", Toast.LENGTH_LONG).show()
                                    showMenu = false
                                },
                                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) }
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (shownavbar) {
                NavigationBar(
                    containerColor = FarmingdaleGreen,
                    modifier = Modifier.height(85.dp)
                ) {
                    navItemsList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = (selectedItemIndex == index),
                            onClick = {
                                selectedItemIndex = index
                                Toast.makeText(Context, item.title, Toast.LENGTH_SHORT).show()
                                navController.navigate(item.route)
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    fontSize = 10.sp,
                                    maxLines = 2,
                                    lineHeight = 12.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
                                )
                            },
                            colors = NavigationBarItemColors(
                                Color.White,
                                Color.White,
                                Color.Transparent,
                                Color.White,
                                Color.White,
                                Color.White,
                                Color.White
                            ),
                            icon = {
                                Icon(
                                    contentDescription = item.title,
                                    imageVector = if (index == selectedItemIndex) item.iconSelected else item.iconUnselected,
                                    modifier = Modifier.padding(bottom = 2.dp)
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            NavHost(navController = navController, startDestination = "SignInScreen") {
                composable(route = "SignInScreen") {
                    signinscreen(navController)
                }
                composable(route = "MainMenuScreen") {
                    Screentitle = "Main Menu"
                    shownavbar = true
                    selectedItemIndex = 0
                    mainmenuscreen(navController = navController, viewModel = viewModel)
                }
                composable(route = "signUpScreen") {
                    signUpScreen(navController)
                }
                composable(route = "RegistrationScreen") {
                    Screentitle = "Registration"
                    selectedItemIndex = 1
                    registrationscreen(navController)
                }
                composable(route = "StudentRecordsScreen") {
                    Screentitle = "Student Records"
                    selectedItemIndex = 2
                    studentrecordsscreen(navController)
                }
                composable(route = "PersonalInformationScreen") {
                    Screentitle = "Personal Information"
                    selectedItemIndex = 3
                    personalinformationscreen(navController)
                }
                composable(route = "FinancialInformationScreen") {
                    Screentitle = "Financial Information"
                    selectedItemIndex = 4
                    financialinformationscreen(navController)
                }
            }
        }
    }
}