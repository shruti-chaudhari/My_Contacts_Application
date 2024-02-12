package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.dataclasses.UserData
import com.example.myapplication.retrofit.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()
    private val _users = MutableLiveData<List<UserData>>()
    val users: LiveData<List<UserData>> get() = _users

    fun fetchUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val fetchedUsers = userRepository.getUsers()
            _users.postValue(fetchedUsers)
        }
    }
}
