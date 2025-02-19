package com.common.components

import android.app.Activity
import android.app.Application
import android.content.Context
import com.common.components.di.component.AppComponent
import com.common.components.di.component.DaggerAppComponent
import com.squareup.picasso.Picasso
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/*
 * we use our AppComponent (now prefixed with Dagger)
 * to inject our Application class.
 * This way a DispatchingAndroidInjector is injected which is
 * then returned when an injector for an activity is requested.
 * */
class AppController : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}

val Activity.injector get() = (application as AppController).component