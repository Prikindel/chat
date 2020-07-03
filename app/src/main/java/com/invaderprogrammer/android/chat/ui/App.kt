package com.invaderprogrammer.android.chat.ui

import android.app.Application
import com.invaderprogrammer.android.chat.presentation.Injection.AppModule
import com.invaderprogrammer.android.chat.presentation.Injection.CacheModule
import com.invaderprogrammer.android.chat.presentation.Injection.RemoteModule
import com.invaderprogrammer.android.chat.presentation.Injection.ViewModelModule
import com.invaderprogrammer.android.chat.ui.activity.RegisterActivity
import com.invaderprogrammer.android.chat.ui.fragment.RegisterFragment
import com.invaderprogrammer.android.chat.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)
}