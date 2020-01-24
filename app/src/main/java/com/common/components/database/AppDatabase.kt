package com.common.components.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.common.components.database.dao.UserDao
import com.common.components.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}