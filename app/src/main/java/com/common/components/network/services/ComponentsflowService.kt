package com.common.components.network.services

import com.common.components.network.models.UsersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ComponentsflowService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getUsers(): Call<UsersResponse>
}