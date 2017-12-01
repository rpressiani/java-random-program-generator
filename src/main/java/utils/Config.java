package utils;

import java.util.Map;

public class Config {

    private Map<String, String> identifier;
    private Map<String, Integer> fields;
    private int variableDeclaratorListLength;

    public Map<String, String> getIdentifier() {
        return identifier;
    }
    public Map<String, Integer> getFields() {
        return fields;
    }
    public int getVariableDeclaratorListLength() {
        return variableDeclaratorListLength - 1;
    }
}
