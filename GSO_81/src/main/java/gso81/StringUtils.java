package gso81;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Character.*;
import static java.lang.Character.isDigit;

public class StringUtils {
    public static String capitalize(String str) {
        StringBuilder builder = new StringBuilder();
        if (isEmpty(str)) {
            return builder.toString();
        }
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (isLetterOrDigit(symbol)) {
                builder.append(toUpperCase(symbol)).append(str, ++i, str.length());
                break;
            } else {
                builder.append(symbol);
            }
        }
        return builder.toString();
    }

    public static boolean isPalindrome(String str) {
        if (isEmpty(str)) {
            return false;
        }
        String lettersAndDigits = leaveLettersAndDigits(str);
        return !lettersAndDigits.isEmpty()
                && lettersAndDigits.equalsIgnoreCase(new StringBuilder(lettersAndDigits).reverse().toString());
    }

    public static String alphabetize(String str) {
        return (isEmpty(str)) ? str : sortLetters(leaveLatinLetters(str));
    }

    static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    static String leaveLettersAndDigits(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLetter(c) || isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String leaveLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLatinLetters(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static boolean isLatinLetters(char c) {
        return (isLowerCaseLatinLetter(c) || isUpperCaseLatinLetter(c));
    }

    private static boolean isLowerCaseLatinLetter(char letter) {
        return ('a' <= letter && letter <= 'z');
    }

    private static boolean isUpperCaseLatinLetter(char letter) {
        return ('A' <= letter && letter <= 'Z');
    }

    private static String sortLetters(String str) {
        Comparator<String> comparator = (s1, s2) -> {
            int r = s1.compareToIgnoreCase(s2);
            return r == 0 ? s1.compareTo(s2) : r;
        };
        List<String> sortedLetters = Arrays.asList(str.split(""));
        sortedLetters.sort(comparator);
        StringBuilder result = new StringBuilder(str.length());
        for (String s : sortedLetters) {
            result.append(s);
        }
        return result.toString();
    }
}
