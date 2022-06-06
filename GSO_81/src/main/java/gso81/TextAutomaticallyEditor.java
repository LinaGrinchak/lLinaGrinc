package gso81;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Character.*;

public class TextAnalyzer {
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
            String onlyLetters = leaveOnlyLetters(str);
            if (!onlyLetters.isEmpty()) {
                return onlyLetters.equalsIgnoreCase(new StringBuilder(onlyLetters).reverse().toString());
            } else return false;
        } else return false;
    }

    public static String alphabetize(String str) {
        if (str != null && !str.isEmpty()) {
            return sortedLetters(str);
        } else return str;
    }

    public static String leaveOnlyLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }


    public static String leaveLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLatinLetters(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static boolean isLatinLetters(char c) {
        return (isLowerCaseLatinLetter(c) || isUpperCaseLatinLetter(c));
    }

    public static boolean isLowerCaseLatinLetter(char letter) {
        return ('a' <= letter && letter <= 'z');
    }

    public static boolean isUpperCaseLatinLetter(char letter) {
        return ('A' <= letter && letter <= 'Z');
    }

    public static String sortedLetters(String str) {
        Comparator<String> comparator = (s1, s2) -> {
            int r = s1.compareToIgnoreCase(s2);
            return r == 0 ? s1.compareTo(s2) : r;
        };

        return Arrays.stream(leaveLatinLetters(str).split("")).sorted(comparator)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
