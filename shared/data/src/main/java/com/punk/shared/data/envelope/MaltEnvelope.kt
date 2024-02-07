package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MaltEnvelope(
    @Json(name = "amount")
    val amount: AmountEnvelope?,
    @Json(name = "name")
    val name: String?
)