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

    public STEntry getRandomVariable(STKey key) {
        try {
            List<STEntry> variables = this.localVariables.get(key.getType());
            return variables.get(RandomGen.getNextInt(variables.size()));
        } catch (NullPointerException e) {
            return new STEntry(null, false);
        }
    }

    public STEntry getRandomMethod(STKey key) {
        try {
            List<STEntry> methods = this.methods.get(key.getType());
            return (STEntry) methods.stream().filter(v -> v.isStatic() == key.isStatic()).toArray()[RandomGen.getNextInt(methods.size())];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            return new STEntry(null, false);
        }
    }

    public STEntry getRandomField(STKey key) {
        try {
            List<STEntry> fields = this.fields.get(key.getType());
            return (STEntry) fields.stream().filter(v -> v.isStatic() == key.isStatic()).toArray()[RandomGen.getNextInt(fields.size())];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
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
