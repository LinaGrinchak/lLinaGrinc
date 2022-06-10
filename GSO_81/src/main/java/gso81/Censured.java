package gso81;

import java.util.StringTokenizer;

import static java.lang.Character.*;

public class Censured {
    private static final String CENSORED = "censored";
    private String censor;

    public Censured(String censor) throws Exception {
        if (censor == null || censor.trim().isEmpty()) {
            throw new Exception("Censored word empty");
        }
        this.censor = censor;
    }

    public String censure(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        } else if (!isWordFitOnTheLine(str)) {
            return str;
        } else if (censor.contains(" ") || censor.contains("-")) {
            return censorOnlyWord(str);
        }
        StringBuilder result = new StringBuilder();
        StringTokenizer strTokens = new StringTokenizer(str, " ");
        while (strTokens.hasMoreTokens()) {
            String currentToken = strTokens.nextToken();
            if (!isWordFitOnTheLine(currentToken)) {
                result.append(currentToken).append(" ");
            } else if (currentToken.length() == censor.length() && currentToken.equalsIgnoreCase(censor)) {
                result.append(CENSORED).append(" ");
            } else {
                String censWord = censorOnlyWord(currentToken);
                result.append(censoredWithoutSeparators(censWord)).append(" ");
               
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private String censorOnlyWord(String str) {
        if (!isContainCensor(str)) {
            return str;
        }
        int startStr = 0;
        int censorLength = censor.length();
        StringBuilder builder = new StringBuilder();
        for (int inxStr = 0; inxStr + censorLength <= str.length(); inxStr++)
            if (str.substring(inxStr, inxStr + censorLength).equalsIgnoreCase(censor)) {
                builder.append(str, startStr, inxStr).append(CENSORED);
                startStr = inxStr + censorLength;
                inxStr += (censorLength - 1);
            }
        builder.append(str.substring(startStr));
        return builder.toString();

    }

    private String censoredWithoutSeparators(String censWord) {
        String onlyLettersWord = leaveDigitAndLetters(censWord);
        if (isContainCensor(onlyLettersWord)) {
            return censorOnlyWord(onlyLettersWord);
        } else {
            return censWord;
        }
    }

    private boolean isWordFitOnTheLine(String str) {
        return str.length() >= censor.length();
    }

    private boolean isContainCensor(String str) {
        return str.toLowerCase().contains(censor.toLowerCase());
    }

    private static String leaveDigitAndLetters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLetter(c) || isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
