package com.dgphoenix.gso81;

import java.util.Arrays;

import static java.lang.Character.*;
import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class StringUtils {
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char symbol = str.trim().charAt(0);
        int posSymbol = str.indexOf(symbol);

        builder.append(str,0,posSymbol).append(toUpperCase(symbol)).append(str, posSymbol+1, str.length());

        return builder.toString();
    }

    public static boolean isPalindrome(String str) {
        if (isEmpty(str)) {
            return false;
        }

        String  revertStr = new StringBuilder(str.trim()).reverse().toString();

        return str.trim().equalsIgnoreCase(revertStr);
    }

    public static String alphabetize(String str) {
        return (isEmpty(str)) ? "" : sortLetters(leaveLatinLetters(str));
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
        char [] letChars = str.toCharArray();
        String[] letters= new String[letChars.length];

        for (int i=0; i<letChars.length; i++){
           letters[i]= String.valueOf(letChars[i]);
        }

        Arrays.sort(letters,CASE_INSENSITIVE_ORDER);

        StringBuilder result = new StringBuilder(str.length());
        for (String s : letters) {
            result.append(s);
        }

        return result.toString();
    }
}
