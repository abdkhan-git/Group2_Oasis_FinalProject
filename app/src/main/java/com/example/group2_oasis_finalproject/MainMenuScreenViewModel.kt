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

    init {
        viewModelScope.launch {
            usersRepository.getUsers().collect { users ->
                if (users.isNotEmpty()) {
                    _currentUser.value = users.first()
                }
            }
        }
    }
}