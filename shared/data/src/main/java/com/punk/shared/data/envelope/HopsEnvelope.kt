package com.punk.shared.data.envelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HopsEnvelope(
    @Json(name = "add")
    val add: String?,
    @Json(name = "amount")
    val amount: AmountEnvelope?,
    @Json(name = "attribute")
    val attribute: String?,
    @Json(name = "name")
    val name: String?
)