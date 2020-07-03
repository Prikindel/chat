package com.invaderprogrammer.android.chat.presentation.Injection

import android.content.Context
import com.invaderprogrammer.android.chat.data.account.AccountCache
import com.invaderprogrammer.android.chat.data.account.AccountRemote
import com.invaderprogrammer.android.chat.data.account.AccountRepositoryImpl
import com.invaderprogrammer.android.chat.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}