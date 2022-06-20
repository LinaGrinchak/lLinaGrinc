package com.dgphoenix.gso81;

import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {
    @Test
    public void isCapitalizeNull() {
        Assert.assertEquals("", StringUtils.capitalize(null));
    }

    @Test
    public void isCapitalizeEmpty() {
        Assert.assertEquals("", StringUtils.capitalize(""));

    }

    @Test
    public void isCapitalizeTextSpaces() {
        Assert.assertEquals("", StringUtils.capitalize("        "));

    }

    @Test
    public void isCapitalizeText() {
        String text = "capitalize";
        String expected = "Capitalize";
        Assert.assertEquals(expected, StringUtils.capitalize(text));
    }

    @Test
    public void isCapitalizeNumber() {
        String text = "3424";
        String expected = "3424";
        Assert.assertEquals(expected, StringUtils.capitalize(text));
    }

    @Test
    public void isPalindromeNull() {
        Assert.assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    public void isPalindromeEmpty() {
        Assert.assertFalse(StringUtils.isPalindrome(""));
    }

    @Test
    public void isPalindromeTextSpaces() {
        Assert.assertFalse(StringUtils.isPalindrome("        "));
    }

    @Test
    public void isPalindromePalindromeStrings() {
        for (String message : new String[]{"Madam", "37573", "   4 a B C b A 4"}) {
            Assert.assertTrue(StringUtils.isPalindrome(message));
        }
    }

    @Test
    public void isPalindromeNoPalindrome() {
        String message = "Palindrome";
        Assert.assertFalse(StringUtils.isPalindrome(message));
    }

    @Test
    public void isAlphabetizeNull() {
        Assert.assertEquals("", StringUtils.alphabetize(null));
    }

    @Test
    public void isAlphabetizeEmpty() {
        Assert.assertEquals("", StringUtils.alphabetize(""));
    }

    @Test
    public void isAlphabetizeTextSpaces() {
        Assert.assertEquals("", StringUtils.alphabetize("        "));
    }

    @Test
    public void isAlphabetizeTextNumber() {
        Assert.assertEquals("", StringUtils.alphabetize("4324"));
    }

    @Test
    public void isAlphabetizeLatinText() {
        String text = "The Holy Bible";
        String expected = "BbeehHilloTy";
        Assert.assertEquals(expected, StringUtils.alphabetize(text));
    }
}
