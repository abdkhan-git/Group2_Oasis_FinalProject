package com.example.group2_oasis_finalproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class SignInScreenViewModel(val usersRepository: UsersRepository = MyApplication.UsersRepository) : ViewModel() {

    suspend fun CheckLogin(RamID : String, Pin : String) : Boolean {
        var Loggedin = CoroutineScope(Dispatchers.IO).async {
            val UserRamIDCheck = usersRepository.getUserRamID(RamID)
            val UserPinCheck = usersRepository.getUserPin(RamID)
            if ( UserRamIDCheck == RamID) {
                    if (UserPinCheck == Pin) {
                        true
                    }
                    else false
                }
                else {false}
        }
        return Loggedin.await()
    }

    @Composable
    fun RedText(X : String)  {
        Text(
            text = "$X",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
        )//END OF TEXT
    }//END OF HEADING

    @Composable
    fun GreenText(X : String)  {
        Text(
            text = "$X",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
        )//END OF TEXT
    }//END OF HEADING

    @Composable
    fun BoldText(X : String)  {
        Text(
            text = "$X",
            fontWeight = FontWeight.Bold,
        )//END OF TEXT
    }//END OF HEADING
}