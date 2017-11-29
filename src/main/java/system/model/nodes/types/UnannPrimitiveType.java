package system.model.nodes.types;

//unannPrimitiveType
//        :	numericType
//        |	'boolean'
//        ;

import system.model.nodes.Node;

import java.util.Random;

public class UnannPrimitiveType implements Node {

    NumericType numericType;

    public UnannPrimitiveType() {
        this.numericType = new NumericType();
    }

    @Override
    public String produce() {
        
        String prod;

        if ((new Random()).nextInt(6) > 0) {
            prod = this.verify(this.numericType.produce());
        } else {
            prod = "boolean ";
        }
        return this.verify(prod);
    }
}
