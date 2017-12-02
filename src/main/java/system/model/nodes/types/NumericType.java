package system.model.nodes.types;

//numericType
//        :	integralType
//        |	floatingPointType
//        ;

import utils.RandomGen;

public class NumericType implements INumericType {
//TODO implement floatingPointType
    INumericType type;

    NumericType() {

        if (RandomGen.getNextInt(6) > 1) {
            this.type = new IntegralType();
        } else {
            this.type = new FloatingPointType();
        }
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
