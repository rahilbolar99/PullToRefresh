package com.common.components.di.module

import com.common.components.ui.UserListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeUserListActivity(): UserListActivity
}