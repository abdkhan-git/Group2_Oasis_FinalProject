package com.example.group2_oasis_finalproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel

class SignUpScreenViewModel(val userRepository: UsersRepository = MyApplication.UsersRepository) : ViewModel() {

    fun addData(user: User) {
        userRepository.addUser(user)
    }
    fun addDataFB(user: User) {
        userRepository.addUser(user)
    }



    @Composable
    fun HeaderText(X: String) {
        Text(
            text = "$X",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
        )//END OF TEXT
    }

}//End of RegistrationScreenViewModel