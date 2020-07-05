package com.invaderprogrammer.android.chat.domain.account

import com.invaderprogrammer.android.chat.domain.interactor.UseCase
import com.invaderprogrammer.android.chat.domain.type.Either
import com.invaderprogrammer.android.chat.domain.type.Failure
import com.invaderprogrammer.android.chat.domain.type.None
import javax.inject.Inject

class Logout @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, None>() {

    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}