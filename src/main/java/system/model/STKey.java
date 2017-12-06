package system.model;

public class STKey {

    private String type;
    private boolean _static;

    public STKey(String type, boolean _static) {
        this.type = type;
        this._static = _static;
    }

    public String getType() {
        return type;
    }

    public boolean isStatic() {
        return _static;
    }
}
