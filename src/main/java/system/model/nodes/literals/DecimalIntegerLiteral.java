package system.model.nodes.literals;

import system.model.nodes.Node;

//DecimalIntegerLiteral
//        :	DecimalNumeral IntegerTypeSuffix?
//        ;

public class DecimalIntegerLiteral implements Node {

    private DecimalNumeral decimalNumeral;
    private IntegerTypeSuffix integerTypeSuffix;

    DecimalIntegerLiteral(String type) {
        this.decimalNumeral = new DecimalNumeral(type);
        this.integerTypeSuffix = new IntegerTypeSuffix(type);
    }

    @Override
    public String produce() {
        return this.verify(decimalNumeral.produce() + integerTypeSuffix.produce());
    }
}
