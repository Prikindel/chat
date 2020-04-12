package com.invaderprogrammer.android.chat.domain.account

import com.invaderprogrammer.android.chat.domain.type.None
import com.invaderprogrammer.android.chat.domain.interactor.UseCase
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}