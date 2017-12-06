package system.model.nodes.classes;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.expressions.Expression;

//variableInitializer
//        :	expression
//        |	arrayInitializer
//        ;

//TODO implement arrayInitializer
public class VariableInitializer implements Node {

    private Expression expression;

    VariableInitializer(STKey key, ScopeTable scopeTable) {
        this.expression = new Expression(key, scopeTable);
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String produce() {
        return this.verify(this.expression.produce());
    }
}
