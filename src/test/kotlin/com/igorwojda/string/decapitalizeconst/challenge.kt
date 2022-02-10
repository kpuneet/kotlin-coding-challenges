package com.igorwojda.string.decapitalizeconst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import java.util.*

private fun decapitalizeConst(str: String): String {
    /*val sString = str.split("_").filter { it.isNotEmpty() }
    if(sString.size <= 1) return ""
   return sString.mapIndexed { index, s ->
        if(index == 0) s.toLowerCase(Locale.ROOT)
        else s.first().toUpperCase() + s.drop(1).toLowerCase()
    }.joinToString("")*/

    val subsStringsList = str.split("_").map { it ->
        it.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }
    return subsStringsList.joinToString("").decapitalize()
}

private class Test {
    @Test
    fun `"FOOBAR" return foobar`() {
        decapitalizeConst("FOOBAR") shouldBeEqualTo "foobar"
    }

    @Test
    fun `"FOO_BAR" return "fooBar"`() {
        decapitalizeConst("FOO_BAR") shouldBeEqualTo "fooBar"
    }

    @Test
    fun `"FOO_BAR_BAZ" return "fooBarBaz"`() {
        decapitalizeConst("FOO_BAR_BAZ") shouldBeEqualTo "fooBarBaz"
    }

    @Test
    fun `"__F_BAR" return "fBar"`() {
        decapitalizeConst("__F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `"F_BAR" return "fBar"`() {
        decapitalizeConst("F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `empty string return empty string`() {
        decapitalizeConst("") shouldBeEqualTo ""
    }
}
