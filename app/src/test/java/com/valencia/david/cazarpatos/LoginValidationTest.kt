package com.valencia.david.cazarpatos

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for login validation logic.
 */
class LoginValidationTest {

    @Test
    fun validEmail_returnsTrue() {
        assertTrue(isValidEmail("test@example.com"))
        assertTrue(isValidEmail("user.name@domain.co"))
        assertTrue(isValidEmail("user+tag@example.org"))
    }

    @Test
    fun invalidEmail_returnsFalse() {
        assertFalse(isValidEmail(""))
        assertFalse(isValidEmail("invalid"))
        assertFalse(isValidEmail("@example.com"))
        assertFalse(isValidEmail("user@"))
        assertFalse(isValidEmail("user @example.com"))
    }

    @Test
    fun validPassword_returnsTrue() {
        assertTrue(isValidPassword("12345678"))
        assertTrue(isValidPassword("00000000"))
        assertTrue(isValidPassword("123456789012345"))
    }

    @Test
    fun invalidPassword_tooShort_returnsFalse() {
        assertFalse(isValidPassword("1234567"))
        assertFalse(isValidPassword(""))
        assertFalse(isValidPassword("0"))
    }

    @Test
    fun invalidPassword_containsNonNumbers_returnsFalse() {
        assertFalse(isValidPassword("12345678a"))
        assertFalse(isValidPassword("abcd1234"))
        assertFalse(isValidPassword("password"))
        assertFalse(isValidPassword("12345 678"))
        assertFalse(isValidPassword("1234-5678"))
    }

    @Test
    fun validPassword_exactlyEightCharacters_returnsTrue() {
        assertTrue(isValidPassword("12345678"))
    }

    // Helper functions matching LoginActivity logic
    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8 && password.all { it.isDigit() }
    }
}
