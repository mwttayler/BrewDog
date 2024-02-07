package com.punk.shared.threading

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ThreadingModule {

    @Binds
    abstract fun bindDispatcherProvider(impl: DispatcherProviderImpl): DispatcherProvider
}
