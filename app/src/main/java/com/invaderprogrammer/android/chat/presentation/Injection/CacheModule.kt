package com.invaderprogrammer.android.chat.presentation.Injection

import android.content.Context
import android.content.SharedPreferences
import com.invaderprogrammer.android.chat.cache.AccountCacheImpl
import com.invaderprogrammer.android.chat.cache.SharedPrefsManager
import com.invaderprogrammer.android.chat.data.account.AccountCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}