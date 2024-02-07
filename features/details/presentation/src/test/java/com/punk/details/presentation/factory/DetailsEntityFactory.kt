package com.punk.details.presentation.factory

import com.punk.details.data.model.Amount
import com.punk.details.data.model.Details
import com.punk.details.data.model.Hops
import com.punk.details.data.model.Ingredients
import com.punk.details.data.model.Malt

object DetailsEntityFactory {

    fun create() = Details(
        imageUrl = null,
        name = "Punk IPA 2007 - 2010",
        description = "Our flagship beer that kick started the craft beer revolution. " +
            "This is James and Martin's original take on an American IPA, subverted with" +
            " punchy New Zealand hops. Layered with new world hops to create an all-out" +
            " riot of grapefruit, pineapple and lychee before a spiky," +
            " mouth-puckering bitter finish.",
        ingredients = Ingredients(
            hops = listOf(
                Hops(
                    name = "Ahtanum",
                    amount = Amount(value = 17.5, unit = "grams"),
                    add = "start",
                    attribute = "bitter"
                ),
                Hops(
                    name = "Chinook",
                    amount = Amount(value = 15.0, unit = "grams"),
                    add = "start",
                    attribute = "bitter"
                )
            ),
            malt = listOf(
                Malt(
                    name = "Extra Pale",
                    amount = Amount(value = 5.3, unit = "kilograms")
                )
            ),
            yeast = "Wyeast 1056 - American Ale™"
        )
    )
}
