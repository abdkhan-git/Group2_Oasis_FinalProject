// MainMenuScreenViewModel.kt
package com.example.group2_oasis_finalproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainMenuScreenViewModel(
    private val usersRepository: UsersRepository = MyApplication.UsersRepository
) : ViewModel() {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _isDarkModeEnabled = MutableStateFlow(false)
    val isDarkModeEnabled: StateFlow<Boolean> = _isDarkModeEnabled

    fun toggleTheme() {
        _isDarkModeEnabled.value = !_isDarkModeEnabled.value
        println("Dark Mode Enabled: ${_isDarkModeEnabled.value}")
    }

    init {
        viewModelScope.launch {
            usersRepository.getUsers().collect { users ->
                if (users.isNotEmpty()) {
                    _currentUser.value = users.first()
                }
            }
        }
    }
    fun checkOldPin(oldPin: String): Boolean {

        return oldPin == "123456" // dummy code
    }

    // Mock function for update  PIN
    fun updatePin(newPin: String): Boolean {

        return true // Assuming the update is successful
    }

}

