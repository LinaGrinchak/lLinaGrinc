package com.dgphoenix.gso81;

import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {
    private static final String MIXED_TEXT = " привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).";
    private static final String[] PALINDROME_TEXTS = new String[]{"Madam", "Алла", "Eve", "37573", "VvA44844AvV", "   4 a B C b A 4"};

    @Test
    public void isPalindromeNull() {
        Assert.assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    public void isCapitalizeNull() {
        Assert.assertEquals("", StringUtils.capitalize(null));
    }

    @Test
    public void isAlphabetizeNull() {
        Assert.assertEquals("", StringUtils.alphabetize(null));
    }

    @Test
    public void isPalindromeEmpty() {
        Assert.assertFalse(StringUtils.isPalindrome(""));
    }

    @Test
    public void isCapitalizeEmpty() {
        Assert.assertEquals("", StringUtils.capitalize(""));

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
    public void isPalindromeTextSpaces() {
        Assert.assertFalse(StringUtils.isPalindrome("        "));
    }

    @Test
    public void isCapitalizeTextSpaces() {
        Assert.assertEquals("", StringUtils.capitalize("        "));

    }

    @Test
    public void isAlphabetizeMixedText() {
        String expectedStr = "aaaaacdddeeeefggGgggGhhhhhhhilmnooooorrrrrsssssttuu";
        
        Assert.assertEquals(expectedStr, StringUtils.alphabetize(MIXED_TEXT));
    }

    @Test
    public void isPalindromeMixedText() {
        Assert.assertFalse(StringUtils.isPalindrome(MIXED_TEXT));
    }

    @Test
    public void isCapitalizeMixedText() {
        String expectedStr = " Привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).";

        Assert.assertEquals(expectedStr, StringUtils.capitalize(MIXED_TEXT));
    }

    @Test
    public void isPalindromePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            Assert.assertTrue(StringUtils.isPalindrome(message));
        }
    }

    @Test
    public void isAlphabetizePalindromeText() {
        String[] alphabetizePalindromeText = {"aadMm", "", "Eev", "", "AAVvvV", "aABbC",};
        
        for (int i = 0; i < PALINDROME_TEXTS.length; i++) {
            Assert.assertEquals(alphabetizePalindromeText[i], StringUtils.alphabetize(PALINDROME_TEXTS[i]));
        }
    }

    @Test
    public void isCapitalizePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            Assert.assertEquals(message, StringUtils.capitalize(message));
        }
    }
}
