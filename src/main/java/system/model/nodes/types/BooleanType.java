package system.model.nodes.types;

public class BooleanType implements IUnannType {

    private String type = "boolean";

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String produce() {
        return this.verify(this.type);
    }
}
