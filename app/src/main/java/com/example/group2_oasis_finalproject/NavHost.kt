package com.example.group2_oasis_finalproject

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SignInScreen") {
        composable(route = "SignInScreen") {
            signinscreen(navController)
        }//End of composable
        composable(route = "MainMenuScreen") {
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
}