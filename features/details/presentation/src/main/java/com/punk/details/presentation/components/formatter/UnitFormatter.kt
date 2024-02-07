package com.punk.details.presentation.components.formatter

import android.content.res.Resources
import com.punk.shared.design.system.R as sharedR

object UnitFormatter {

    private const val GRAMS = "grams"
    private const val KILOGRAMS = "kilograms"

    fun format(resources: Resources, unit: String): String {
        return when (unit) {
            GRAMS -> resources.getString(sharedR.string.unit_grams)
            KILOGRAMS -> resources.getString(sharedR.string.unit_kilograms)
            else -> unit
        }
    }
}
