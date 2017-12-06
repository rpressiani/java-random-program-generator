package system.model.nodes.literals;

import system.model.STKey;
import system.model.nodes.Node;

//literal
//        :	IntegerLiteral
//        |	FloatingPointLiteral
//        |	BooleanLiteral
//        |	CharacterLiteral
//        |	StringLiteral
//        |	NullLiteral
//        ;

public class Literal implements IPrimaryNoNewArray_lfno_primary{

    private ILiteral literal;

    public Literal(STKey key) {
        switch (key.getType()) {
            case "int":
            case "byte":
            case "short":
            case "long":
                this.literal = new IntegerLiteral(key);
                break;

            case "char": //TODO implement Character Literal
                this.literal = new IntegerLiteral(key);
                break;

            case "boolean":
                this.literal = new BooleanLiteral();
                break;

            case "double":
            case "float":
                this.literal = new FloatingPointLiteral(key);
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
