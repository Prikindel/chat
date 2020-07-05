package com.invaderprogrammer.android.chat.domain.account

import com.invaderprogrammer.android.chat.domain.interactor.UseCase
import com.invaderprogrammer.android.chat.domain.type.None
import javax.inject.Inject

class GetAccount @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<AccountEntity, None>() {

    override suspend fun run(params: None) = accountRepository.getCurrentAccount()
}