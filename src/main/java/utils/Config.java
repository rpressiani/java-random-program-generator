package utils;

import java.util.Map;

public class Config {

    private Map<String, String> identifier;
    private Map<String, Integer> fields;
    private Map<String, Integer> methods;
    private Map<String, Integer> statements;
    private int variableDeclaratorListLength;

    public Map<String, String> getIdentifier() {
        return identifier;
    }

    public Map<String, Integer> getFields() {
        return fields;
    }

    public Map<String, Integer> getMethods() {
        return methods;
    }

    public Map<String, Integer> getStatements() {
        return statements;
    }

    public int getVariableDeclaratorListLength() {
        return variableDeclaratorListLength - 1;
    }
}
