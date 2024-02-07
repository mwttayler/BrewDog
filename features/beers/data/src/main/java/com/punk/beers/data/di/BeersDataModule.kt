package com.punk.beers.data.di

import com.punk.beers.data.repository.BeersRepository
import com.punk.beers.data.repository.BeersRepositoryImpl
import com.punk.shared.data.di.PunkApiModule
import com.punk.shared.threading.ThreadingModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        PunkApiModule::class,
        ThreadingModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class BeersDataModule {

    @Binds
    internal abstract fun bindListRepository(impl: BeersRepositoryImpl): BeersRepository
}
