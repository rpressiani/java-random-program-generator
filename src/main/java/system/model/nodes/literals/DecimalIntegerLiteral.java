package system.model.nodes.literals;

import system.model.STKey;
import system.model.nodes.Node;

//DecimalIntegerLiteral
//        :	DecimalNumeral IntegerTypeSuffix?
//        ;

public class DecimalIntegerLiteral implements Node {

    private DecimalNumeral decimalNumeral;
    private IntegerTypeSuffix integerTypeSuffix;

    DecimalIntegerLiteral(STKey key) {
        this.decimalNumeral = new DecimalNumeral(key);
        this.integerTypeSuffix = new IntegerTypeSuffix(key);
    }

    @Override
    public String produce() {
        return this.verify(decimalNumeral.produce() + integerTypeSuffix.produce());
    }
}
