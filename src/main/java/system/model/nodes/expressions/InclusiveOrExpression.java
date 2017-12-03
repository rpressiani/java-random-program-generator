package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;

//inclusiveOrExpression
//        :	exclusiveOrExpression
//        |	inclusiveOrExpression '|' exclusiveOrExpression
//        ;

//TODO inclusiveOrExpression '|' exclusiveOrExpression
public class InclusiveOrExpression implements Node {

    private ExclusiveOrExpression exclusiveOrExpression;

    public InclusiveOrExpression(String type, ScopeTable scopeTable) {
        this.exclusiveOrExpression = new ExclusiveOrExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(exclusiveOrExpression.produce());
    }
}
