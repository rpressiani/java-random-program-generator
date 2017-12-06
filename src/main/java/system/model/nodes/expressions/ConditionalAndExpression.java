package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//conditionalAndExpression
//        :	inclusiveOrExpression
//        |	conditionalAndExpression '&&' inclusiveOrExpression
//        ;

//TODO conditionalAndExpression '&&' inclusiveOrExpression
public class ConditionalAndExpression implements Node {

    private InclusiveOrExpression inclusiveOrExpression;

    ConditionalAndExpression(STKey key, ScopeTable scopeTable) {
        this.inclusiveOrExpression = new InclusiveOrExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(inclusiveOrExpression.produce());
    }
}
