package system.model.nodes.classes;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.expressions.AdditiveExpression;

//variableInitializer
//        :	expression
//        |	arrayInitializer
//        ;

//TODO implement arrayInitializer
public class VariableInitializer implements Node {

//    TODO Should be Expression
    private AdditiveExpression expression;

    VariableInitializer(STKey key, ScopeTable scopeTable) {
        this.expression = new AdditiveExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(this.expression.produce());
    }
}
