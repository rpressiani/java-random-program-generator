package system.model.nodes.literals;

import system.model.nodes.Node;

//literal
//        :	IntegerLiteral
//        |	FloatingPointLiteral
//        |	BooleanLiteral
//        |	CharacterLiteral
//        |	StringLiteral
//        |	NullLiteral
//        ;

public class Literal implements Node{

    private ILiteral literal;

    public Literal(String type) {
        switch (type) {
            case "int":
            case "byte":
            case "short":
            case "long":
                this.literal = new IntegerLiteral(type);
                break;

            case "char": //TODO implement Character Literal
                this.literal = new IntegerLiteral(type);
                break;

            case "boolean":
                this.literal = new BooleanLiteral();
                break;

            case "double":
            case "float":
                this.literal = new FloatingPointLiteral(type);
                break;

            default:
                this.literal = new NullLiteral();
                break;
        }
    }

    @Override
    public String produce() {
        return this.verify(literal.produce());
    }
}
