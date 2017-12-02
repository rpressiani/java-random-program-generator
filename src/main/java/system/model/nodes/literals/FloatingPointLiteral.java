package system.model.nodes.literals;

//FloatingPointLiteral
//        :	DecimalFloatingPointLiteral
//        |	HexadecimalFloatingPointLiteral
//        ;

//TODO HexadecimalFloatingPointLiteral

public class FloatingPointLiteral implements ILiteral {

    private DecimalFloatingPointLiteral decimalFloatingPointLiteral;

    FloatingPointLiteral(String type) {
        this.decimalFloatingPointLiteral = new DecimalFloatingPointLiteral(type);
    }

    @Override
    public String produce() {
        return this.verify(decimalFloatingPointLiteral.produce());
    }
}
