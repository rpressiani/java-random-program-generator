package system.model;

public class STEntry {

    private String identifier;
    private boolean _static;

    public STEntry(String identifier, boolean _static) {
        this.identifier = identifier;
        this._static = _static;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean isStatic() {
        return _static;
    }
}
