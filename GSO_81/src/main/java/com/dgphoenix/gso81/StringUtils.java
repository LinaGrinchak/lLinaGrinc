package com.dgphoenix.gso81;

import java.util.Arrays;

import static java.lang.Character.*;
import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class StringUtils {
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(str.length());
        char symbol = str.charAt(0);
        builder.append(toUpperCase(symbol)).append(str,  1, str.length());
        return builder.toString();
    }

    public static boolean isPalindrome(String str) {
        if (isEmpty(str)) {
            return false;
        }
        String revertStr = new StringBuilder(str.trim()).reverse().toString();
        return str.trim().equalsIgnoreCase(revertStr);
    }

    public static String alphabetize(String str) {
        return (isEmpty(str)) ? "" : sortLetters(leaveLatinLetters(str));
    }

    static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static String leaveLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
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
        String[] letters =  str.split("");
        Arrays.sort(letters, CASE_INSENSITIVE_ORDER);
        StringBuilder result = new StringBuilder(str.length());
        for (String s : letters) {
            result.append(s);
        }
        return result.toString();
    }
}
