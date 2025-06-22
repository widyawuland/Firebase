package com.widya.internetlistapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class UserViewModel : ViewModel() {
    var userList by mutableStateOf<List<User>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                userList = RetrofitClient.apiService.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}