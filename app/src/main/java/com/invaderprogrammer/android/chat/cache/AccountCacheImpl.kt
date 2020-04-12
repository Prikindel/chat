package com.invaderprogrammer.android.chat.cache

import com.invaderprogrammer.android.chat.data.account.AccountCache
import com.invaderprogrammer.android.chat.domain.type.Either
import com.invaderprogrammer.android.chat.domain.type.None
import com.invaderprogrammer.android.chat.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}