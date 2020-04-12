package com.invaderprogrammer.android.chat.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.invaderprogrammer.android.chat.R
import com.invaderprogrammer.android.chat.cache.AccountCacheImpl
import com.invaderprogrammer.android.chat.cache.SharedPrefsManager
import com.invaderprogrammer.android.chat.data.account.AccountRepositoryImpl
import com.invaderprogrammer.android.chat.domain.account.AccountRepository
import com.invaderprogrammer.android.chat.domain.account.Register
import com.invaderprogrammer.android.chat.remote.account.AccountRemoteImpl
import com.invaderprogrammer.android.chat.remote.core.NetworkHandler
import com.invaderprogrammer.android.chat.remote.core.Request
import com.invaderprogrammer.android.chat.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abcd@m.com", "abcd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
