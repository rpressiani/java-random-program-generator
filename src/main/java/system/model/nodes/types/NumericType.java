package system.model.nodes.types;

//numericType
//        :	integralType
//        |	floatingPointType
//        ;

import system.model.nodes.Node;

public class NumericType implements Node {
//TODO implement floatingPointType
    IntegralType integralType;

    public NumericType() {
        this.integralType = new IntegralType();
    }

    @Override
    public String produce() {
        return this.verify(this.integralType.produce());
    }
}
