package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FermentationEnvelope(
    @Json(name = "temp")
    val temperature: TemperatureEnvelope?
)