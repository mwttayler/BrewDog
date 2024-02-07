package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientsEnvelope(
    @Json(name = "hops")
    val hops: List<HopsEnvelope>?,
    @Json(name = "malt")
    val malt: List<MaltEnvelope>?,
    @Json(name = "yeast")
    val yeast: String?
)