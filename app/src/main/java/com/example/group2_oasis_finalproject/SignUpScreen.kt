package com.example.group2_oasis_finalproject

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun signUpScreen(navController: NavController) {

    var Emailtext by rememberSaveable { mutableStateOf("") }
    var RamIDtext by rememberSaveable { mutableStateOf("") }
    var Pintext by rememberSaveable { mutableStateOf("") }
    var Firsttext by rememberSaveable { mutableStateOf("") }
    var Lasttext by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    val viewModel = SignUpScreenViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fsclogorgb),
                contentDescription = "SignUp Image",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(1f)
            )

            Text(
                text = "Create an Account!",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

//        SignupscreenViewModel.HeaderText(X = "Create an Account!")

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(value = Emailtext, onValueChange = { Emailtext = it.replace("\\s".toRegex(), "") }, label = { Text(text = "Email") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
            OutlinedTextField(value = Firsttext, onValueChange = { Firsttext = it.replace("\\s".toRegex(), "") }, label = { Text(text = "First Name") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = Lasttext, onValueChange = { Lasttext = it.replace("\\s".toRegex(), "") }, label = { Text(text = "Last Name") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = Pintext, onValueChange = { Pintext = it.replace("\\s".toRegex(), "") }, label = { Text(text = "Pin (6 Digits)") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            OutlinedTextField(value = RamIDtext, onValueChange = { RamIDtext = it.replace("\\s".toRegex(), "") }, label = { Text(text = "Ram ID (8 Digits)") }, modifier = Modifier.fillMaxWidth())
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (Firsttext.isEmpty() || Lasttext.isEmpty() || Emailtext.isEmpty() || Pintext.isEmpty() || RamIDtext.isEmpty()) {
                        Toast.makeText(context, "Please fill out all fields!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val newUser =
                                    User(Emailtext, Firsttext, Lasttext, Pintext, RamIDtext)
                                viewModel.userRepository.addUser(newUser)
                                viewModel.userRepository.addUserFB(newUser)
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(context, "User successfully signed up!", Toast.LENGTH_LONG).show()
                                    navController.popBackStack()
                                }
                            } catch (e: Exception) {
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(context, "An error occurred: ${e.message}", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = FarmingdaleGreen,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Sign Up")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { navController.navigate("SignInScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Log In")
            }
        }

        Text(
            text = "© 2024 5Members Company L.P. and its affiliates.\n" +
                    "This software contains confidential and proprietary information of Ellucian or its subsidiaries.",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}
