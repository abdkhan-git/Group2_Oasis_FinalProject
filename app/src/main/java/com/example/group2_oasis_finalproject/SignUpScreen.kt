package com.example.group2_oasis_finalproject

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Break
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController

@Composable
fun signUpScreen(navController: NavController) {

    var Emailtext by rememberSaveable { mutableStateOf("") }
    var RamIDtext by rememberSaveable { mutableStateOf("") }
    var Pintext by rememberSaveable { mutableStateOf("") }
    var Firsttext by rememberSaveable { mutableStateOf("") }
    var Lasttext by rememberSaveable { mutableStateOf("") }
    val Context = LocalContext.current

    var SignupscreenViewModel =  SignUpScreenViewModel()


    Column(Modifier.padding(50.dp)) {
        SignupscreenViewModel.HeaderText(X = "Create an Account!")
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(value = Emailtext, onValueChange = { Emailtext = it }, label = { Text(text = "Email") })
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(value = Firsttext, onValueChange = { Firsttext = it }, label = { Text(text = "First Name") })
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(value = Lasttext, onValueChange = { Lasttext = it }, label = { Text(text = "Last Name") })
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = Pintext, onValueChange = { Pintext = it }, label = { Text(text = "Pin (6 Digits)") })
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = RamIDtext, onValueChange = { RamIDtext = it }, label = { Text(text = "Ram ID (8 Digits)") })
        Spacer(modifier = Modifier.padding(10.dp))
        Row() {
            Spacer(modifier = Modifier.padding(50.dp))
            Button(onClick = {
                if (Firsttext == "" || Lasttext == "" || Emailtext == "" || Pintext == "" || RamIDtext == ""){
                    Toast.makeText(Context, "Please Don't leave fields Empty!", Toast.LENGTH_LONG).show()
                    Break
                } else if ((Emailtext.contains("@") == false && Emailtext.contains(".com") == false) || (Emailtext.contains("@") == false && Emailtext.contains(".edu") == false)){
                    Toast.makeText(Context, "Please put in a proper email!", Toast.LENGTH_LONG).show()
                    Break
                } else if (Pintext.length != 6) {
                    Toast.makeText(Context, "Your Pin is too Long or Short", Toast.LENGTH_LONG).show()
                    Break
                } else if (Pintext.isDigitsOnly() == false) {
                    Toast.makeText(Context, "Don't Put letters in your Pin", Toast.LENGTH_LONG).show()
                    Break
                } else if (RamIDtext.length != 9) {
                    Toast.makeText(Context, "Your Ram ID is too Long or Short", Toast.LENGTH_LONG).show()
                    Break
                } else if (RamIDtext.subSequence(2,9).isDigitsOnly() == false) {
                    Toast.makeText(Context, "Please just put numbers after R", Toast.LENGTH_LONG)
                        .show()
                    Break
                } else if (RamIDtext.startsWith("R") == false) {
                    Toast.makeText(Context, "Please start your Ram ID with a R", Toast.LENGTH_LONG).show()
                    Break
                } else {
                    try {
                        val newUser = User(Emailtext, Firsttext, Lasttext, Pintext, RamIDtext)
                        SignupscreenViewModel.userRepository.addUser(newUser)
                        SignupscreenViewModel.userRepository.addUserFB(newUser)
                    } catch (e : IllegalArgumentException) {
                        Break
                    }
                    navController.popBackStack()
                }
            }) { Text(text = "Sign up") }
        }
    }
}