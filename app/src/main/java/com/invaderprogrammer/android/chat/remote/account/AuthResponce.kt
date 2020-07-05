package com.invaderprogrammer.android.chat.remote.account

import com.invaderprogrammer.android.chat.domain.account.AccountEntity
import com.invaderprogrammer.android.chat.remote.core.BaseResponse

class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)