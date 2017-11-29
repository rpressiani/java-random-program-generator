package system.model.nodes.types;

//unannType
//        :	unannPrimitiveType
//        |	unannReferenceType
//        ;

import system.model.nodes.Node;

//TODO implement reference Type
public class UnannType implements Node {

    UnannPrimitiveType unannPrimitiveType;

    public UnannType() {
        this.unannPrimitiveType = new UnannPrimitiveType();
    }

    @Override
    public String produce() {
        return this.verify(this.unannPrimitiveType.produce());
    }
}
