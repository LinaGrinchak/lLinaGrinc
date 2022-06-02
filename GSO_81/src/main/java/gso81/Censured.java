package gso81;

public class Censured {
    private static final String CENSORED = "censored";
    private String censor;

    public Censured(String censor) {
        this.censor = censor;
    }

    public String censureAll(String str) {
        if (str != null && censor != null && !str.isEmpty() && !censor.isEmpty()
                && str.length() >= censor.length()) {
            int startStr = 0;
            int censorLength = censor.length();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i + censorLength <= str.length(); i++)
                if (str.substring(i, i + censorLength).equalsIgnoreCase(censor)) {
                    builder.append(str, startStr, i).append(CENSORED);
                    startStr = i + censorLength;
                    i += (censorLength - 1);
                }
            builder.append(str.substring(startStr));
            return builder.toString();
        }
        return str;
    }

    public String censure(String str) {
        if (str != null && censor != null && !str.isEmpty() && !censor.isEmpty()
                && str.length() >= censor.length()) {
            return str.replace(censor, CENSORED);
        }
        return str;

    }
}
