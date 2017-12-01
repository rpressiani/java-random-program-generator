package system.model.nodes.types;

//unannPrimitiveType
//        :	numericType
//        |	'boolean'
//        ;

import java.util.Random;

public class UnannPrimitiveType implements IUnannType {

    private IUnannType type;

    UnannPrimitiveType() {

        if ((new Random()).nextInt(6) > 0) {
            this.type = new NumericType();
        } else {
            this.type = new BooleanType();
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
