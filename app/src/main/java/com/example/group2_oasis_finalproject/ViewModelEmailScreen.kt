package com.example.group2_oasis_finalproject

import android.app.Application
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.google.firebase.firestore.FirebaseFirestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UsersRepository) : ViewModel() {

    // This will hold the list of users
    private val _users = mutableStateOf<List<User>>(emptyList())
//    val users: Recomposer.State<List<User>> = _users

    // This function will load the users from the repository
    fun loadUsers() {
        viewModelScope.launch {
            // Fetch the users from the repository (adjust depending on your data source)
            userRepository.getAllUsers().collect { userList ->
                _users.value = userList
            }
        }
    }

    // You can add any other functions to get specific user data, like:
    fun getUserByRamID(ramId: String): User? {
        return _users.value.find { it.RamID == ramId }
    }
}
