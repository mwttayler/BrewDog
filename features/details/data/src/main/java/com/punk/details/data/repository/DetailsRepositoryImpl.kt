package com.punk.details.data.repository

import com.punk.details.data.mapper.DetailsMapper
import com.punk.shared.data.api.PunkApi
import com.punk.shared.threading.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class DetailsRepositoryImpl @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val punkApi: PunkApi
) : DetailsRepository {

    override suspend fun fetch(id: Int) = withContext(dispatcherProvider.io()) {
        val details = punkApi.getBeer(id).first()
        return@withContext details.let(DetailsMapper::mapFrom)
    }
}
