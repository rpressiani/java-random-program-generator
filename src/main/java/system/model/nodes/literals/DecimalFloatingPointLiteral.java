package system.model.nodes.literals;

import system.model.STKey;
import system.model.nodes.Node;

import java.util.Random;

//DecimalFloatingPointLiteral
//        :	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
//        |	'.' Digits ExponentPart? FloatTypeSuffix?
//        |	Digits ExponentPart FloatTypeSuffix?
//        |	Digits FloatTypeSuffix
//        ;

//TODO implement remaining

public class DecimalFloatingPointLiteral implements Node{

    private String decimalFloatintPointLiteral;

    DecimalFloatingPointLiteral(STKey key) {
        Random random = new Random();
        switch (key.getType()) {
            case "double":
                this.decimalFloatintPointLiteral = String.valueOf(random.nextDouble());
                break;
            case "float":
                this.decimalFloatintPointLiteral = String.valueOf(random.nextFloat()) + new FloatTypeSuffix().produce();
                break;
        }
    }

    @Override
    public String produce() {
        return this.verify(decimalFloatintPointLiteral);
    }
}
