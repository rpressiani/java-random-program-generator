package system.model.nodes.types;

//unannType
//        :	unannPrimitiveType
//        |	unannReferenceType
//        ;

//TODO implement reference Type
public class UnannType implements IUnannType {

    private IUnannType type;

    public UnannType() {
        this.type = new UnannPrimitiveType();
    }

    @Override
    public String produce() {
        return this.verify(this.type.produce());
    }

    @Override
    public String getType() {
        return this.type.getType();
    }
}
