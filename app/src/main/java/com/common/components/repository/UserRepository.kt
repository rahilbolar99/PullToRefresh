package com.common.components.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.common.components.database.dao.UserDao
import com.common.components.network.ComponentflowSyncer
import com.common.components.repository.models.UserModel
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val componentflowSyncer: ComponentflowSyncer
) {

    fun getUsers(): LiveData<List<UserModel>> {
        componentflowSyncer.refreshUsers()
        return Transformations.map(userDao.getUsersStream()) { users ->
            users.map {
                UserModel(
                    it.title,
                    it.description,
                    it.profile_image
                )
            }
        }
    }
}