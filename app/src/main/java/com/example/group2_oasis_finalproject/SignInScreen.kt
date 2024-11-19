package com.example.group2_oasis_finalproject

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
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
        Modifier.fillMaxWidth(),
        Arrangement.Bottom,
        Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.fsclogorgb),
            contentDescription = "SignIn Image",
            modifier = Modifier
                .padding(start = 10.dp, top = 100.dp, end = 10.dp, bottom = 50.dp)
        )

        OutlinedTextField(value = UserRamIDtext, onValueChange = {UserRamIDtext = it}, label = {Text(text = "Ram ID")})
        Spacer(Modifier.padding(10.dp))
        OutlinedTextField(value = UserPintext, onValueChange = {UserPintext = it}, label = {Text(text = "Six-Digit Login PIN")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword))
        Spacer(Modifier.padding(10.dp))
        Row{
            OutlinedButton(onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    CoroutineScopeRunning = true
                    if (viewModel.CheckLogin(UserRamIDtext, UserPintext) == true) { PassedInspection = true }
                    else { PassedInspection = false }
                    withContext(Dispatchers.Main) {
                        if (PassedInspection == true) {  CoroutineScopeRunning = false; navController.navigate("MainMenuScreen") }
                        else {  CoroutineScopeRunning = false; Toast.makeText(Context, "Login Failed", Toast.LENGTH_LONG).show() }
                    }
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = FarmingdaleGreen
                )
            ) { Text(text = "Login")}

            Spacer(Modifier.padding(10.dp))

            Button(
                onClick = { navController.navigate("signUpScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = FarmingdaleGreen,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Register")
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
        Arrangement.Bottom,
        Alignment.CenterHorizontally
    ) {
        Text(text = "LOGIN ABOVE by entering your User ID (Ram ID or SSN) and your six-digit LOGIN PIN for access to the Farmingdale State College Online Administrative Student Information System (OASIS).", modifier = Modifier.padding(5.dp))

        Text(buildAnnotatedString {
            append("IMPORTANT: Please read and understand the Colleges ")
            withLink(LinkAnnotation.Url("https://oasis.farmingdale.edu/genhelp/termsofusage.htm",
                TextLinkStyles(style = SpanStyle(color = Color.Blue)))) { append("Academic Advisement Terms of Usage") }
            append(" before you login to this system! If you have any questions regarding the advisement process, contact your ")
            withLink(LinkAnnotation.Url("https://oasis.farmingdale.edu/genhelp/termsofusage.htm",
                TextLinkStyles(style = SpanStyle(color = Color.Blue)))) { append("Department Contact.") }
        }, modifier = Modifier.padding(5.dp))

        Text(text = "Please call the Registrar's Office at (934) 420-2776 during business hours (Monday - Friday 9:00am - 4:30pm) if you have difficulty logging in. ", modifier = Modifier.padding(5.dp))

        if (CoroutineScopeRunning == true) { LinearProgressIndicator(Modifier.fillMaxWidth())}
    }
}