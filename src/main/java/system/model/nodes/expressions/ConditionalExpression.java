package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//conditionalExpression
//        :	conditionalOrExpression
//        |	conditionalOrExpression '?' expression ':' conditionalExpression
//        ;

//TODO conditionalOrExpression '?' expression ':' conditionalExpression
public class ConditionalExpression implements Node {

    private ConditionalOrExpression conditionalOrExpression;

    ConditionalExpression(STKey key, ScopeTable scopeTable) {
        this.conditionalOrExpression = new ConditionalOrExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(conditionalOrExpression.produce());
    }
}
