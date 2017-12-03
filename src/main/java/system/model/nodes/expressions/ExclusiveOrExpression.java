package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;

//exclusiveOrExpression
//        :	andExpression
//        |	exclusiveOrExpression '^' andExpression
//        ;

//TODO exclusiveOrExpression '^' andExpression
public class ExclusiveOrExpression implements Node {

    private AndExpression andExpression;

    public ExclusiveOrExpression(String type, ScopeTable scopeTable) {
        this.andExpression = new AndExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(andExpression.produce());
    }
}
