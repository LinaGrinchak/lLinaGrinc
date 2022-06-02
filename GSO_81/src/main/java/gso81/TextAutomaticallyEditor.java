package gso81;

import static java.lang.Character.*;

public class TextAutomaticallyEditor {

    String capitalize(String str) {
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

    boolean isPalindrome(String str) {
        if (str != null && !str.isEmpty()) {
            str = leaveOnlyLetters(str);
            if (!str.isEmpty()) {
                return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
            } else return false;
        } else return false;
    }

    String alphabetize(String str) {
        if (str != null && !str.isEmpty()) {
            str = leaveOnlyLatinLetters(str);
            String lettersUpperCase = sortedLetters(leaveUpperCaseLatinLetters(str));
            if (!str.isEmpty()) {
                String sortedStr = sortedLetters(str.toLowerCase());
                if (!lettersUpperCase.isEmpty()) {
                    StringBuilder result = new StringBuilder(str.length());
                    for (int i = 0; i < lettersUpperCase.length(); i++) {
                        int pos = sortedStr.indexOf(toLowerCase(lettersUpperCase.charAt(i)));
                        sortedStr = result.append(sortedStr, 0, pos)
                                .append(lettersUpperCase.charAt(i))
                                .append(sortedStr.substring(++pos)).toString();
                        result.setLength(0);
                    }
                }
                return sortedStr;
            } else return str;
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

    public static String leaveOnlyLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLowerCaseLatinLetter(c) || isUpperCaseLatinLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String leaveLowerCaseLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLowerCaseLatinLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String leaveUpperCaseLatinLetters(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isUpperCaseLatinLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static boolean isLowerCaseLatinLetter(char letter) {
        return ('a' <= letter && letter <= 'z');
    }

    public static boolean isUpperCaseLatinLetter(char letter) {
        return ('A' <= letter && letter <= 'Z');
    }

    public static String sortedLetters(String str) {
        return str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
