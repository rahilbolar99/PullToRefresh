package com.common.components.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.common.components.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<UserEntity>): LongArray

    @Query("SELECT * FROM users")
    fun getUsers(): List<UserEntity>

    @Query("SELECT * FROM users")
    fun getUsersStream(): LiveData<List<UserEntity>>
}