package system.model.nodes.types;

//numericType
//        :	integralType
//        |	floatingPointType
//        ;

public class NumericType implements IUnannType {
//TODO implement floatingPointType
    IntegralType integralType;

    public NumericType() {
        this.integralType = new IntegralType();
    }

    @Override
    public String produce() {
        return this.verify(this.integralType.produce());
    }

    @Override
    public String getType() {
        return this.integralType.getType();
    }
}
