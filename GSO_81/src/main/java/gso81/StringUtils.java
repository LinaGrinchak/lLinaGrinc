package gso81;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Character.*;
import static java.lang.Character.isDigit;

public class StringUtils {
    public static String capitalize(String str) {
        StringBuilder builder = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            for (int i = 0; i < str.length(); i++)
                if (isLetterOrDigit(str.charAt(i))) {
                    builder.append(toUpperCase(str.charAt(i))).append(str, ++i, str.length());
                    break;
                } else {
                    builder.append(str.charAt(i));
                }
        }
        return builder.toString();
    }

    public static boolean isPalindrome(String str) {
        if (str != null && !str.isEmpty()) {
            String onlyLetters = leaveLettersAndDigit(str);
            if (!onlyLetters.isEmpty()) {
                return onlyLetters.equalsIgnoreCase(new StringBuilder(onlyLetters).reverse().toString());
            }
            return false;
        }
        return false;
    }

    public static String alphabetize(String str) {
        if (str != null && !str.isEmpty()) {
            return sortedLetters(str);
        }
        return str;
    }


    static String leaveLettersAndDigit(String str) {
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

    private static String sortedLetters(String str) {
        Comparator<String> comparator = (s1, s2) -> {
            int r = s1.compareToIgnoreCase(s2);
            return r == 0 ? s1.compareTo(s2) : r;
        };
        List<String> sortedLetters = Arrays.asList(leaveLatinLetters(str).split(""));
        sortedLetters.sort(comparator);
        StringBuilder result = new StringBuilder(str.length());
        for (String s : sortedLetters) {
            result.append(s);
        }
        return result.toString();
    }
}
