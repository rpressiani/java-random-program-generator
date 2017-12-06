package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//exclusiveOrExpression
//        :	andExpression
//        |	exclusiveOrExpression '^' andExpression
//        ;

//TODO exclusiveOrExpression '^' andExpression
public class ExclusiveOrExpression implements Node {

    private AndExpression andExpression;

    ExclusiveOrExpression(STKey key, ScopeTable scopeTable) {
        this.andExpression = new AndExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(andExpression.produce());
    }
}
