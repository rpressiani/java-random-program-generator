package system.model.nodes.literals;

//FloatingPointLiteral
//        :	DecimalFloatingPointLiteral
//        |	HexadecimalFloatingPointLiteral
//        ;

//TODO HexadecimalFloatingPointLiteral

import system.model.STKey;

public class FloatingPointLiteral implements ILiteral {

    private DecimalFloatingPointLiteral decimalFloatingPointLiteral;

    FloatingPointLiteral(STKey key) {
        this.decimalFloatingPointLiteral = new DecimalFloatingPointLiteral(key);
    }

    @Override
    public String produce() {
        return this.verify(decimalFloatingPointLiteral.produce());
    }
}
