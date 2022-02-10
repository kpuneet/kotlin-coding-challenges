package com.igorwojda.string.ispalindrome.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPalindrome(str: String): Boolean {
    /*val chars = str.toCharArray()
    val size = chars.size
    var i = 0
    var j = size-1
    while ( i < size ) {
        if(i == ((size -1)/2)) return true
        if (chars[i] == chars[j]) {
            i++
            j--
        } else return false
    }
    return false*/

    return if (str.isEmpty() || str.length == 1) {
        true
    } else {
        if (str.first() == str.last()) {
            isPalindrome(str.substring(1 until str.lastIndex))
        } else {
            false
        }
    }
}

private class Test {

    @Test
    fun `"aba" is a palindrome`() {
        isPalindrome("aba") shouldBeEqualTo true
    }

    @Test
    fun `" aba" is not a palindrome`() {
        isPalindrome(" aba") shouldBeEqualTo false
    }

    @Test
    fun `"aba " is not a palindrome`() {
        isPalindrome("aba ") shouldBeEqualTo false
    }

    @Test
    fun `"greetings" is not a palindrome`() {
        isPalindrome("greetings") shouldBeEqualTo false
    }

    @Test
    fun `"1000000001" a palindrome`() {
        isPalindrome("1000000001") shouldBeEqualTo true
    }

    @Test
    fun `"Fish hsif" is not a palindrome`() {
        isPalindrome("Fish hsif") shouldBeEqualTo false
    }

    @Test
    fun `"pennep" a palindrome`() {
        isPalindrome("pennep") shouldBeEqualTo true
    }
}
