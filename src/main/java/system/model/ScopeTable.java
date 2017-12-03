package system.model;

import utils.RandomGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScopeTable {

    private Map<String, ArrayList<String>> localVariables;
    private Map<String, ArrayList<String>> methods;

    public ScopeTable() {
        this.localVariables = new HashMap<>();
        this.methods = new HashMap<>();
    }

    public ScopeTable(ScopeTable outerScopeTable) {
        this.localVariables = deepCopy(outerScopeTable.getLocalVariables());
        this.methods = deepCopy(outerScopeTable.getMethods());
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

    private Map<String, ArrayList<String>> deepCopy(Map<String, ArrayList<String>> original){

        Map<String, ArrayList<String>> copy = new HashMap<>();
        for(Map.Entry<String, ArrayList<String>> entry : original.entrySet()){
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }

    private Map<String, ArrayList<String>> getLocalVariables() {
        return localVariables;
    }

    private Map<String,ArrayList<String>> getMethods() {
        return methods;
    }
}
