package system.model.nodes.types;

//unannPrimitiveType
//        :	numericType
//        |	'boolean'
//        ;

import system.model.nodes.Node;

public class UnannPrimitiveType implements Node {

    NumericType numericType;

    public UnannPrimitiveType() {
        this.numericType = new NumericType();
    }

    @Override
    public String produce() {
        return this.verify(this.numericType.produce());
    }
}
