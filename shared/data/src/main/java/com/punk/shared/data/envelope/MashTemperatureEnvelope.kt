package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MashTemperatureEnvelope(
    @Json(name = "duration")
    val duration: Int?,
    @Json(name = "temp")
    val temp: TemperatureEnvelope?
)