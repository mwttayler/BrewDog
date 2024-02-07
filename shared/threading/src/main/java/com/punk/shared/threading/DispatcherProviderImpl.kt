package com.punk.shared.threading

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {

    override fun main() = Dispatchers.Main

    override fun default() = Dispatchers.Default

    override fun io() = Dispatchers.IO

    override fun unconfined() = Dispatchers.Unconfined
}
