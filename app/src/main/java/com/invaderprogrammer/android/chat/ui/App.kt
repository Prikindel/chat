package com.invaderprogrammer.android.chat.ui

import android.app.Application
import com.invaderprogrammer.android.chat.presentation.Injection.AppModule
import com.invaderprogrammer.android.chat.presentation.Injection.CacheModule
import com.invaderprogrammer.android.chat.presentation.Injection.RemoteModule
import com.invaderprogrammer.android.chat.presentation.Injection.ViewModelModule
import com.invaderprogrammer.android.chat.ui.core.navigation.RouteActivity
import com.invaderprogrammer.android.chat.ui.register.RegisterActivity
import com.invaderprogrammer.android.chat.ui.register.RegisterFragment
import com.invaderprogrammer.android.chat.ui.firebase.FirebaseService
import com.invaderprogrammer.android.chat.ui.home.ChatsFragment
import com.invaderprogrammer.android.chat.ui.home.HomeActivity
import com.invaderprogrammer.android.chat.ui.login.LoginFragment
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

    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)

    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    //services
    fun inject(service: FirebaseService)
}