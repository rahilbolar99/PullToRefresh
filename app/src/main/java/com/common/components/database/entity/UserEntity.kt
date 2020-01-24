package com.common.components.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @ColumnInfo(name = "title") @PrimaryKey @field:NonNull val title: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "profile_image") val profile_image: String?
)