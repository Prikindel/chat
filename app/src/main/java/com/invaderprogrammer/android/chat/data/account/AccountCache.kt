package com.invaderprogrammer.android.chat.data.account

import com.invaderprogrammer.android.chat.domain.type.Either
import com.invaderprogrammer.android.chat.domain.type.None
import com.invaderprogrammer.android.chat.domain.type.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}