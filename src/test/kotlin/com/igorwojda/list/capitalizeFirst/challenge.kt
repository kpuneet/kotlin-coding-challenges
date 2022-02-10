package com.igorwojda.list.capitalizeFirst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun capitalizeFirst(list: List<String>): List<String> {
    //return list.map { it.capitalize() }


    /*return if (list.isEmpty())  emptyList()
    else listOf(list.first().capitalize()) + capitalizeFirst(list.drop(1))*/
    return if (list.isEmpty())  emptyList()
    else list.take(1).map { it.capitalize() } + capitalizeFirst(list.drop(1))

}

private class Test {
    @Test
    fun `capitalize list with one string`() {
        capitalizeFirst(listOf("igor")) shouldBeEqualTo listOf("Igor")
    }

    @Test
    fun `capitalize list with two strings`() {
        capitalizeFirst(listOf("igor", "wojda")) shouldBeEqualTo listOf("Igor", "Wojda")
    }

    @Test
    fun `capitalize list with empty string`() {
        capitalizeFirst(listOf("")) shouldBeEqualTo listOf("")
    }

    @Test
    fun `capitalize list with sentence`() {
        capitalizeFirst(listOf("what a", "beautiful", "morning")) shouldBeEqualTo listOf(
            "What a",
            "Beautiful",
            "Morning"
        )
    }
}
