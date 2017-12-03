package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;

//conditionalOrExpression
//        :	conditionalAndExpression
//        |	conditionalOrExpression '||' conditionalAndExpression
//        ;

//TODO conditionalOrExpression '||' conditionalAndExpression
public class ConditionalOrExpression implements Node {

    private ConditionalAndExpression conditionalAndExpression;

    public ConditionalOrExpression(String type, ScopeTable scopeTable) {
        this.conditionalAndExpression = new ConditionalAndExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(this.conditionalAndExpression.produce());
    }
}
