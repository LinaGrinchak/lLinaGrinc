package gso81;

import org.junit.Test;

public class TestStringUtils {
    private static final String MIXED_TEXT = "привет Привет ages 12 through 14 (6-8 Grades) and high school from ages 15 through 19 (9-12 Grades).";
    private static final String[] PALINDROME_TEXTS = new String[]{"Was it a car or a cat I saw?", "Madam, I’m Adam", "Алла", "Eve", "37573", "VvA44844AvV", "VvA44a564AvV", "   4 a B C b A 4"};
    String inputText = "   fvcv 4 f2fvcfv";

    private void isPalindromeTest(String message) {
        System.out.println("isPalindrome: " + message + " : " + StringUtils.isPalindrome(message));
    }

    private void capitalizeTest(String message) {
        System.out.println("capitalizeTest: " + message + " : " + StringUtils.capitalize(message));
    }

    private void alphabetizeTest(String message) {
        System.out.println("alphabetize: " + message + " : " + StringUtils.alphabetize(message));
    }

    @Test
    public void doTestPalindromeNull() {
        isPalindromeTest(null);
    }

    @Test
    public void doTestCapitalizeNull() {
        capitalizeTest(null);
    }

    @Test
    public void doTestAlphabetizeNull() {
        alphabetizeTest(null);
    }

    @Test
    public void doTestPalindromeEmpty() {
        isPalindromeTest("");
    }

    @Test
    public void doTestCapitalizeEmpty() {
        capitalizeTest("");
    }

    @Test
    public void doTestAlphabetizeEmpty() {
        alphabetizeTest("");
    }

    @Test
    public void doTestAlphabetizeTextSpaces() {
        alphabetizeTest("        ");
    }

    @Test
    public void doTestPalindromeTextSpaces() {
        isPalindromeTest("        ");
    }

    @Test
    public void doTestCapitalizeTextSpaces() {
        capitalizeTest("        ");
    }

    @Test
    public void doTestAlphabetizeMixedText() {
        alphabetizeTest(MIXED_TEXT);
    }

    @Test
    public void doTestPalindromeMixedText() {
        isPalindromeTest(MIXED_TEXT);
    }

    @Test
    public void doTestCapitalizeMixedText() {
        capitalizeTest(MIXED_TEXT);
    }

    @Test
    public void doTestAlphabetizePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            alphabetizeTest(message);
        }
    }

    @Test
    public void doTestPalindromePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            isPalindromeTest(message);
        }
    }

    @Test
    public void doTestCapitalizePalindromeText() {
        for (String message : PALINDROME_TEXTS) {
            capitalizeTest(message);
        }
    }

    @Test
    public void doTestAlphabetizeInputText() {

        alphabetizeTest(inputText);

    }

    @Test
    public void doTestPalindromeInputText() {
        capitalizeTest(inputText);
    }

    @Test
    public void doTestCapitalizeInputText() {
        capitalizeTest(inputText);
    }

}
