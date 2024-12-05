package com.example.group2_oasis_finalproject

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun ViewEmailScreen(ramId: String, usersRepository: UsersRepository) {
    // ViewModel with factory to inject the UsersRepository
    val viewModel: UserViewModel = viewModel(factory = UserViewModelFactory(usersRepository))

    // Observe the user state from ViewModel
    val user by viewModel.user.collectAsState(initial = null)

    // Trigger loading of user data when the Composable is launched
    LaunchedEffect(ramId) {
        viewModel.loadUserData(ramId)
    }

    // Scrollable Column to avoid overlapping and enable scroll
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // Make the entire column scrollable
            .padding(16.dp)
    ) {

        // Image
        Image(
            painter = painterResource(id = R.drawable.fsclogorgb),
            contentDescription = "Transparent Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Title
        Text(
            text = "View E-mail Address(es)",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Description Text
        Text(
            text = """
                NOTE: This page displays the current email address information on file. 
                The off-campus email addresses listed on this page will be included in the college's semester-specific 
                "registered student" email distribution lists, for any semester that you are taking classes. 
                Please keep your email addresses current so that you will receive all important college communications.
                
                If the email address information is blank, then we do not have an email address on file for you. 
                This page is display only. You may update your email address information on the Update Email Addresses page.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium.copy(
                lineHeight = 24.sp, // Adjust line height for better readability
                fontSize = 14.sp // Adjust font size if necessary
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Conditional display based on user data state
        if (user == null) {
            // Show loading state
            Text(
                text = "\n Email: bebop@farmingdale.edu \n" +
                        "\n Name: Cowboy Bebop \n " +
                        "\n Ram: R12345678",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        } else {
            // Display user information if available
            //can't get it to function
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Email: ${user!!.Email}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "First Name: ${user!!.First}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Last Name: ${user!!.Last}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "RAM ID: ${user!!.RamID}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Spacer to push content up before the footer
        Spacer(modifier = Modifier.weight(1f))

        // Footer Section: Copyright Text
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            // Footer text
            Text(
                text = "© 2024 Ellucian Company L.P. and its affiliates.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}


// ViewModel
class UserViewModel(private val usersRepository: UsersRepository) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    fun loadUserData(ramId: String) {
        viewModelScope.launch {
            // Collect user data from the repository and update the user state
            usersRepository.getUser(ramId).collect { userData ->
                // Log the fetched data to ensure it's being collected
                Log.d("UserViewModel", "Fetched user data: $userData")
                _user.value = userData
            }
        }
    }
}



// ViewModel Factory
class UserViewModelFactory(private val usersRepository: UsersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(usersRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
