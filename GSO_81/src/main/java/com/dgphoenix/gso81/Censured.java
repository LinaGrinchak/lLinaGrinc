package com.dgphoenix.gso81;

import java.util.StringTokenizer;

import static com.dgphoenix.gso81.StringUtils.isEmpty;

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
        if (isEmpty(str)) {
            return "";
        }
        StringTokenizer strTokens = new StringTokenizer(str, " ");
        StringBuilder result = new StringBuilder();
        while (strTokens.hasMoreTokens()) {
            String currentToken = strTokens.nextToken();
            result.append(currentToken.equalsIgnoreCase(censor) ? CENSORED : currentToken).append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

}
