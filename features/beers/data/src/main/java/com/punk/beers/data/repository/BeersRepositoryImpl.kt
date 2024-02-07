package com.punk.beers.data.repository

import com.punk.beers.data.mapper.BeerMapper
import com.punk.shared.data.api.PunkApi
import com.punk.shared.threading.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BeersRepositoryImpl @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val punkApi: PunkApi
) : BeersRepository {

    override suspend fun fetch() = withContext(dispatcherProvider.io()) {
        return@withContext punkApi.getBeers().map(BeerMapper::mapFrom)
    }
}
