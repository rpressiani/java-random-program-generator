package system.model;

import utils.RandomGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScopeTable {

    private Map<String, ArrayList<STEntry>> fields;
    private Map<String, ArrayList<STEntry>> localVariables;
    private Map<String, ArrayList<STEntry>> methods;

    public ScopeTable() {
        this.localVariables = new HashMap<>();
        this.methods = new HashMap<>();
        this.fields = new HashMap<>();
    }

    public ScopeTable(ScopeTable outerScopeTable) {
        this.localVariables = deepCopy(outerScopeTable.localVariables);
        this.methods = deepCopy(outerScopeTable.methods);
        this.fields = deepCopy(outerScopeTable.fields);
    }

    public void addField(String type, STEntry identifier) {
        this.fields.computeIfAbsent(type, k -> new ArrayList<>()).add(identifier);
    }

    public void addVariable(String type, STEntry identifier) {
        this.localVariables.computeIfAbsent(type, k -> new ArrayList<>()).add(identifier);
    }

    public void addMethod(String type, STEntry identifier) {
        this.methods.computeIfAbsent(type, k -> new ArrayList<>()).add(identifier);
    }

    protected List<STEntry> getLocalVariables(String type) {
        return this.localVariables.get(type);
    }

    public STEntry getRandomVariable(String type) {
        try {
            List<STEntry> variables = this.localVariables.get(type);
            return variables.get(RandomGen.getNextInt(variables.size()));
        } catch (NullPointerException e) {
            return new STEntry(null, false);
        }
    }

    public STEntry getRandomMethod(String type) {
        try {
            List<STEntry> methods = this.methods.get(type);
            return methods.get(RandomGen.getNextInt(methods.size()));
        } catch (NullPointerException e) {
            return new STEntry(null, false);
        }
    }

    public STEntry getRandomField(String type) {
        try {
            List<STEntry> fields = this.fields.get(type);
            return fields.get(RandomGen.getNextInt(fields.size()));
        } catch (NullPointerException e) {
            return new STEntry(null, false);
        }
    }

    private Map<String, ArrayList<STEntry>> deepCopy(Map<String, ArrayList<STEntry>> original) {

        Map<String, ArrayList<STEntry>> copy = new HashMap<>();
        for (Map.Entry<String, ArrayList<STEntry>> entry : original.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }

}
