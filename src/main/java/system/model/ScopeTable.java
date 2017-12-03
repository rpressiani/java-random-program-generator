package system.model;

import utils.RandomGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScopeTable {

    private Map<String, ArrayList<String>> localVariables;

    public ScopeTable() {
        this.localVariables = new HashMap<>();
    }

    public ScopeTable(ScopeTable outerScopeTable) {
        this.localVariables = outerScopeTable.getOuterScopeTable();
    }

    public void add(String type, String identifier) {
        this.localVariables.computeIfAbsent(type, k -> new ArrayList<>()).add(identifier);
    }

    public List<String> get(String type) {
        return this.localVariables.get(type);
    }

    public String getRandom(String type) {
        try {
            List<String> variables = this.localVariables.get(type);
            return variables.get(RandomGen.getNextInt(variables.size()));
        } catch (NullPointerException e) {
            return null;
        }
    }

    private Map<String,ArrayList<String>> getOuterScopeTable() {
        return localVariables;
    }
}
