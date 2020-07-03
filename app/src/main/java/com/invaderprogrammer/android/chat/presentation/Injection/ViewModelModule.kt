package com.invaderprogrammer.android.chat.presentation.Injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.invaderprogrammer.android.chat.presentation.viewmodel.AccountViewModel
import com.invaderprogrammer.android.chat.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(accountViewModel: AccountViewModel): ViewModel
}