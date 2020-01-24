package com.common.components.di.module

import android.app.Application
import androidx.room.Room
import com.common.components.database.AppDatabase
import com.common.components.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DbModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java, "architecture_components.db")
            .allowMainThreadQueries().build()
    }


    /*
     * We need the Dao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */
    @Provides
    @Singleton
    internal fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}