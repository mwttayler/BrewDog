package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VolumeEnvelope(
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "value")
    val value: Int?
)