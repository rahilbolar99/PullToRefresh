package com.common.components.network.models

import com.common.components.database.entity.UserEntity
import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("has_more") val has_more: Boolean,
    @SerializedName("rows") val users: List<User>
)

data class User(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("imageHref") val profile_image: String?
) {
    fun toUserEntity(): UserEntity {
        return UserEntity(
            title,
            description,
            profile_image
        )
    }
}