package com.punk.details.data.di

import com.punk.details.data.repository.DetailsRepository
import com.punk.details.data.repository.DetailsRepositoryImpl
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
abstract class DetailsDataModule {

    @Binds
    internal abstract fun bindListRepository(impl: DetailsRepositoryImpl): DetailsRepository
}
