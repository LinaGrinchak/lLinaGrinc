package com.dgphoenix.gso81;

import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {
    private static final String MIXED_TEXT = " привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).";
    private static final String[] PALINDROME_TEXTS = new String[]{"Madam", "Алла", "Eve", "37573", "VvA44844AvV", "   4 a B C b A 4"};

    @Test
    public void isPalindromeNull() {
        Assert.assertTrue(!StringUtils.isPalindrome(null));
    }

    @Test
    public void isCapitalizeNull() {
        Assert.assertTrue(StringUtils.capitalize(null).equals(""));
    }

    @Test
    public void isAlphabetizeNull() {
        Assert.assertTrue(StringUtils.alphabetize(null).equals(""));
    }

    @Test
    public void isPalindromeEmpty() {
        Assert.assertTrue(!StringUtils.isPalindrome(""));
    }

    @Test
    public void isCapitalizeEmpty() {
        Assert.assertTrue(StringUtils.capitalize("").equals(""));

    }

    @Test
    public void isAlphabetizeEmpty() {
        Assert.assertTrue(StringUtils.alphabetize("").equals(""));
    }

    @Test
    public void isAlphabetizeTextSpaces() {
        Assert.assertTrue(StringUtils.alphabetize("        ").equals(""));
    }

    @Test
    public void isPalindromeTextSpaces() {
        Assert.assertTrue(!StringUtils.isPalindrome("        "));
    }

    @Test
    public void isCapitalizeTextSpaces() {
        Assert.assertTrue(StringUtils.capitalize("        ") == "");

    }

    @Test
    public void isAlphabetizeMixedText() {
        Assert.assertTrue(StringUtils.alphabetize(MIXED_TEXT).equals("aaaaacdddeeeefGGggggghhhhhhhilmnooooorrrrrsssssttuu"));
    }

    @Test
    public void isPalindromeMixedText() {
        Assert.assertTrue(!StringUtils.isPalindrome(MIXED_TEXT));
    }

    @Test
    public void isCapitalizeMixedText() {
        Assert.assertTrue(StringUtils.capitalize(MIXED_TEXT)
                .equals(" Привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades)."));
    }

    @Test
    public void isPalindromePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            Assert.assertTrue(StringUtils.isPalindrome(message));
        }
    }

    @Test
    public void isAlphabetizePalindromeText() {
        String[] alphabetizePalindromeText = {
                "aadMm", "", "Eev", "", "AAVVvv", "AaBbC",
        };
        for (int i=0; i<PALINDROME_TEXTS.length; i++) {
             Assert.assertTrue(StringUtils.alphabetize(PALINDROME_TEXTS[i]).equals(alphabetizePalindromeText[i]));
        }
    }

    @Test
    public void isCapitalizePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            Assert.assertTrue(StringUtils.capitalize(message).equals(message));
        }
    }


}
