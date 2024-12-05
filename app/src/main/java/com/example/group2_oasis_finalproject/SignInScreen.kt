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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen
import com.example.group2_oasis_finalproject.ui.theme.lightgraybutton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun signinscreen(navController: NavController) {

    var UserRamIDtext by rememberSaveable { mutableStateOf("") }
    var UserPintext by rememberSaveable { mutableStateOf("") }
    var viewModel = viewModel {SignInScreenViewModel()}
    val Context = LocalContext.current
    var PassedInspection : Boolean = false
    var CoroutineScopeRunning = false

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        Arrangement.Bottom,
        Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fsclogorgb),
                contentDescription = "SignIn Image",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(1f)
            )

            Spacer(Modifier.padding(top = 30.dp))

            Text(
                text = "Welcome to OASIS",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "Online Administrative Student Information System",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = "Login to your account below.",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 15.sp,
//                fontWeight = FontWeight.Bold,
            )

            Spacer(Modifier.padding(top = 30.dp))
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            Arrangement.spacedBy(20.dp),
            Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = UserRamIDtext, onValueChange = {UserRamIDtext = it.replace("\\s".toRegex(), "")}, label = {Text(text = "Ram ID")}, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = UserPintext, onValueChange = {UserPintext = it.replace("\\s".toRegex(), "")}, label = {Text(text = "Six-Digit Login PIN")}, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword))

            Row {
                OutlinedButton(
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            CoroutineScopeRunning = true
                            if (viewModel.CheckLogin(UserRamIDtext, UserPintext) == true) {
                                PassedInspection = true
                            } else {
                                PassedInspection = false
                            }
                            withContext(Dispatchers.Main) {
                                if (PassedInspection == true) {
                                    CoroutineScopeRunning =
                                        false; navController.navigate("MainMenuScreen")
                                } else {
                                    CoroutineScopeRunning = false; Toast.makeText(
                                        Context,
                                        "Login Failed",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = FarmingdaleGreen,
                        contentColor = lightgraybutton
                    )
                ) { Text(text = "Login") }

                Spacer(Modifier.padding(15.dp))

                Button(
                    onClick = { navController.navigate("signUpScreen") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = lightgraybutton,
                        contentColor = FarmingdaleGreen
                    )
                ) {
                    Text(text = "Register")
                }
            }
        }

        Column(
            Modifier
                .fillMaxSize(),
            Arrangement.Bottom,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN ABOVE by entering your User ID (Ram ID or SSN) and your six-digit LOGIN PIN for access to the Farmingdale State College Online Administrative Student Information System (OASIS).",
                modifier = Modifier.padding(5.dp)
            )

            Text(buildAnnotatedString {
                append("IMPORTANT: Please read and understand the Colleges ")
                withLink(
                    LinkAnnotation.Url(
                        "https://oasis.farmingdale.edu/genhelp/termsofusage.htm",
                        TextLinkStyles(style = SpanStyle(color = Color.Blue))
                    )
                ) { append("Academic Advisement Terms of Usage") }
                append(" before you login to this system! If you have any questions regarding the advisement process, contact your ")
                withLink(
                    LinkAnnotation.Url(
                        "https://oasis.farmingdale.edu/genhelp/termsofusage.htm",
                        TextLinkStyles(style = SpanStyle(color = Color.Blue))
                    )
                ) { append("Department Contact.") }
            }, modifier = Modifier.padding(5.dp),
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = "Please call the Registrar's Office at (934) 420-2776 during business hours (Monday - Friday 9:00am - 4:30pm) if you have difficulty logging in. ",
                modifier = Modifier.padding(5.dp),
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )

            if (CoroutineScopeRunning == true) {
                LinearProgressIndicator(Modifier.fillMaxWidth())
            }
        }
    }
}