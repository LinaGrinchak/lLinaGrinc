package gso81;

import static java.lang.Character.*;

public class TextAutomaticallyEditor {

    String capitalize(String str) {
        StringBuilder builder = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            for (int i = 0; i < str.length(); i++)
                if (isLetterOrDigit(str.charAt(i))) {
                    builder.append(toUpperCase(str.charAt(i))).append(str, i + 1, str.length());
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
    String alphabetize(String str) {
        if (str != null && !str.isEmpty()) {
            str = str.replaceAll("[^a-zA-Z]", "");
            String lettersUpperCase = sortedLetters(str.replaceAll("[^A-Z]", ""));
            if (!str.isEmpty()) {
                String sortedStr = sortedLetters(str.toLowerCase());
               if(!lettersUpperCase.isEmpty()){
                   for (int i = 0; i  < lettersUpperCase.length(); i++){
                       String letter =String.valueOf(lettersUpperCase.charAt(i));
                       sortedStr = sortedStr.replaceFirst(letter.toLowerCase(),letter);
                   }
               }
            return sortedStr;
            } else return str;
        } else return str;
    }

    public static String sortedLetters(String str){
        return str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
