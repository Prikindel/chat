package com.invaderprogrammer.android.chat.data.account

import com.invaderprogrammer.android.chat.domain.type.Either
import com.invaderprogrammer.android.chat.domain.type.None
import com.invaderprogrammer.android.chat.domain.type.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}