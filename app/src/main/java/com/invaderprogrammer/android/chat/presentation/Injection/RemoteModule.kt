package com.invaderprogrammer.android.chat.presentation.Injection

import com.invaderprogrammer.android.chat.BuildConfig
import com.invaderprogrammer.android.chat.data.account.AccountRemote
import com.invaderprogrammer.android.chat.remote.account.AccountRemoteImpl
import com.invaderprogrammer.android.chat.remote.core.Request
import com.invaderprogrammer.android.chat.remote.service.ApiService
import com.invaderprogrammer.android.chat.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}