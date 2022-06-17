package com.dgphoenix.gso81;

import java.util.StringTokenizer;

import static com.dgphoenix.gso81.StringUtils.isEmpty;
import static com.dgphoenix.gso81.StringUtils.leaveLettersAndDigits;

public class Censured {
    private static final String CENSORED = "censored";
    private String censor;

    public Censured(String censor) throws Exception {
        if (isEmpty(censor)) {
            throw new Exception("Censored word empty");
        }
        this.censor = censor;
    }

    public String censure(String str) {
        if (isEmpty(censor) || !isWordFitOnTheLine(str)) {
            return str;
        } else if (censor.contains(" ") || censor.contains("-")) {
            return censorOnlyWord(str);
        }
        StringBuilder result = new StringBuilder();
        StringTokenizer strTokens = new StringTokenizer(str, " ");
        while (strTokens.hasMoreTokens()) {
            String currentToken = strTokens.nextToken();
            if (!isWordFitOnTheLine(currentToken)) {
                result.append(currentToken);
            } else if (currentToken.length() == censor.length() && currentToken.equalsIgnoreCase(censor)) {
                result.append(CENSORED);
            } else {
                String censuredOnlyWord = censorOnlyWord(currentToken);
                result.append(censorWithoutSeparators(censuredOnlyWord));
            }
            result.append(" ");
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

        for (int inxStr = 0; inxStr + censorLength <= str.length(); inxStr++) {
            if (str.substring(inxStr, inxStr + censorLength).equalsIgnoreCase(censor)) {
                builder.append(str, startStr, inxStr).append(CENSORED);
                startStr = inxStr + censorLength;
                inxStr += (censorLength - 1);
            }
        }
        builder.append(str.substring(startStr));

        return builder.toString();
    }

    private String censorWithoutSeparators(String str) {
        String lettersAndDigitsWord = leaveLettersAndDigits(str);
        return isContainCensor(lettersAndDigitsWord) ? censorOnlyWord(lettersAndDigitsWord) : str;
    }

    private boolean isWordFitOnTheLine(String str) {
        return str.length() >= censor.length();
    }

    private boolean isContainCensor(String str) {
        return str.toLowerCase().contains(censor.toLowerCase());
    }
}