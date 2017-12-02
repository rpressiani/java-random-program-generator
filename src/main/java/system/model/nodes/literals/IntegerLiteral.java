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
    @Override
    public String produce() {
        return "0";
    }
}
