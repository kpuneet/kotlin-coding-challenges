package com.igorwojda.string.ispalindrome.permutation

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPermutationPalindrome(str: String): Boolean {
    val charMap = str.groupingBy { it }.eachCount()
    val filtered = charMap.filter { it.value % 2 ==1}
    return filtered.size <= 1

}

private class Test {
    @Test
    fun `"gikig" is a palindrome`() {
        isPermutationPalindrome("gikig") shouldBeEqualTo true
    }

    @Test
    fun `"ooookvk" is a palindrome`() {
        isPermutationPalindrome("ooookvk") shouldBeEqualTo true
    }

    @Test
    fun `"sows" is not a palindrome`() {
        isPermutationPalindrome("sows") shouldBeEqualTo false
    }

    @Test
    fun `"tami" is not a palindrome`() {
        isPermutationPalindrome("tami") shouldBeEqualTo false
    }
}
