package system.model.nodes.literals;

//IntegerLiteral
//        :	DecimalIntegerLiteral
//        |	HexIntegerLiteral
//        |	OctalIntegerLiteral
//        |	BinaryIntegerLiteral
//        ;

//TODO HexIntegerLiteral
//TODO OctalIntegerLiteral
//TODO BinaryIntegerLiteral

import system.model.STKey;

public class IntegerLiteral implements ILiteral {

    private DecimalIntegerLiteral decimalIntegerLiteral;

    IntegerLiteral(STKey key) {
        this.decimalIntegerLiteral = new DecimalIntegerLiteral(key);
    }

    @Override
    public String produce() {
        return this.verify(decimalIntegerLiteral.produce());
    }
}
