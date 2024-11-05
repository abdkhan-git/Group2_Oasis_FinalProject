package com.example.group2_oasis_finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun signinscreen(navController: NavController) {
    var userID by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxWidth(), Arrangement.Bottom, Alignment.CenterHorizontally) {
        Spacer(Modifier.padding(20.dp))
        Text(text = "LOGIN BELOW by entering your User ID (Ram ID or SSN) and your six-digit LOGIN PIN for access to the Farmingdale State College Online Administrative Student Information System (OASIS).")
        Spacer(Modifier.padding(20.dp))
        TextField(value = userID, onValueChange = {userID = it}, label = {Text(text = "User ID")})
        TextField(value = userID, onValueChange = {userID = it}, label = {Text(text = "Six-Digit Login PIN")})
        Button(onClick = { navController.navigate("MainMenuScreen") }) { Text(text = "Login")}
    }
    Column(Modifier.fillMaxWidth().fillMaxSize(), Arrangement.Bottom, Alignment.CenterHorizontally) {
        Text(text = "Please call the Registrar's Office at (934) 420-2776 during business hours (Monday - Friday 9:00am - 4:30pm) if you have difficulty logging in. ")
        Spacer(Modifier.padding(20.dp))
    }
}