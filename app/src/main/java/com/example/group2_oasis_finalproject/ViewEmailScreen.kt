package com.example.group2_oasis_finalproject

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

// Composable function
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

    // UI Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header Section
        Text(
            text = "View E-mail Address(es)",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = """
                NOTE: This page displays the current email address information on file. 
                The off-campus email addresses listed on this page will be included in the college's semester-specific 
                "registered student" email distribution lists, for any semester that you are taking classes. 
                Please keep your email addresses current so that you will receive all important college communications.
                
                If the email address information is blank, then we do not have an email address on file for you. 
                This page is display only. You may update your email address information on the Update Email Addresses page.
            """.trimIndent(),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Conditional display based on user data state
        if (user == null) {
            // Show loading state
            Text(
                text = "Loading user data...",
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            // Display user information
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
    }
}


// ViewModel
class UserViewModel(private val usersRepository: UsersRepository) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    fun loadUserData(ramId: String) {
        viewModelScope.launch {
            usersRepository.getUser(ramId).collectLatest { _user.value = it }
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
