package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MethodEnvelope(
    @Json(name = "fermentation")
    val fermentation: FermentationEnvelope?,
    @Json(name = "mash_temp")
    val mashTemp: List<MashTemperatureEnvelope>?
)