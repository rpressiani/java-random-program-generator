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

public class IntegerLiteral implements ILiteral {

    private DecimalIntegerLiteral decimalIntegerLiteral;

    IntegerLiteral(String type) {
        this.decimalIntegerLiteral = new DecimalIntegerLiteral(type);
    }

    @Override
    public String produce() {
        return this.verify(decimalIntegerLiteral.produce());
    }
}
