package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//inclusiveOrExpression
//        :	exclusiveOrExpression
//        |	inclusiveOrExpression '|' exclusiveOrExpression
//        ;

//TODO inclusiveOrExpression '|' exclusiveOrExpression
public class InclusiveOrExpression implements Node {

    private ExclusiveOrExpression exclusiveOrExpression;

    InclusiveOrExpression(STKey key, ScopeTable scopeTable) {
        this.exclusiveOrExpression = new ExclusiveOrExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(exclusiveOrExpression.produce());
    }
}
