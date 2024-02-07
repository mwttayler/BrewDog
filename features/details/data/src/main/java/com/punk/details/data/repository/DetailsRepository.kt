package com.punk.details.data.repository

import com.punk.details.data.model.Details

interface DetailsRepository {
    suspend fun fetch(id: Int): Details
}
