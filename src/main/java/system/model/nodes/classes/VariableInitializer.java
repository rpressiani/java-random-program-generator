package system.model.nodes.classes;

import system.model.nodes.Node;
import system.model.nodes.expressions.Expression;

//variableInitializer
//        :	expression
//        |	arrayInitializer
//        ;

//TODO implement arrayInitializer
public class VariableInitializer implements Node {

    private Expression expression;

    VariableInitializer(String type) {
        this.expression = new Expression(type);
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String produce() {
        return this.verify(this.expression.produce());
    }
}
