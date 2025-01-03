package com.example.group2_oasis_finalproject

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.group2_oasis_finalproject.RegistrationUI.registrationscreen


@Composable
fun navHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SignInScreen") {
        composable(route = "SignInScreen") {
            signinscreen(navController)
        }//End of composable
        composable(route = "signUpScreen") {
            signUpScreen(navController)
        }//End of composable
        composable(route = "MainMenuScreen") {
            mainmenuscreen(navController, viewModel())
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

        composable(route = "GraduationListFall2024") {
            GraduationListScreen(term = "Fall 2024")
        }
        composable(route = "GraduationListWinter2025") {
            GraduationListScreen(term = "Winter 2025")
        }

        composable(route = "ChangePinScreen") {
//            ChangePinScreen(navController)
        }//End of composable

        composable(route = "FinancialInformationScreen") {
            financialinformationscreen(navController)
        }
    }//End of Navhost
}