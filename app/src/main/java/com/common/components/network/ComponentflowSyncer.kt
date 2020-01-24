package com.common.components.network

import android.text.TextUtils
import com.common.components.database.dao.UserDao
import com.common.components.network.models.UsersResponse
import com.common.components.network.services.ComponentsflowService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject

class ComponentflowSyncer @Inject constructor(
    private val componentflowService: ComponentsflowService,
    private val usersDao: UserDao,
    private val executor: Executor
) {
    private val TAG = ComponentflowSyncer::class.java.simpleName

    fun refreshUsers() {
        componentflowService.getUsers().enqueue(object : Callback<UsersResponse> {
            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                 println(" Failed to Pull data :-   $t.message")
            }

            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    users?.users?.filterNot {
                        //NUll condition is checked here for primary key while parsing
                        TextUtils.isEmpty(it.title)
                    }?.map {
                        usersDao.insert(it.toUserEntity())
                    }
                } else {
                    TODO("Unsuccessful response not implemented")
                }
            }
        })
    }
}