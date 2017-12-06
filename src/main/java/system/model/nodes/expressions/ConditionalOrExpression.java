package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//conditionalOrExpression
//        :	conditionalAndExpression
//        |	conditionalOrExpression '||' conditionalAndExpression
//        ;

//TODO conditionalOrExpression '||' conditionalAndExpression
public class ConditionalOrExpression implements Node {

    private ConditionalAndExpression conditionalAndExpression;

    ConditionalOrExpression(STKey key, ScopeTable scopeTable) {
        this.conditionalAndExpression = new ConditionalAndExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(this.conditionalAndExpression.produce());
    }
}
