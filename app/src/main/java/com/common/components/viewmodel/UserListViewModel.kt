package com.common.components.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.common.components.repository.UserRepository
import com.common.components.repository.models.UserModel
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val reloadTrigger = MutableLiveData<Boolean>()
    private val users: LiveData<List<UserModel>> = Transformations.switchMap(reloadTrigger) {
        userRepository.getUsers()
    }

    init {
        refreshUsers()
    }

    fun getUsers(): LiveData<List<UserModel>> = users

    fun refreshUsers() {
        reloadTrigger.value = true
    }
}