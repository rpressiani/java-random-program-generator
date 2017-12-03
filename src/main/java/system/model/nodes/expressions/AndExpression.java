package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;

//andExpression
//        :	equalityExpression
//        |	andExpression '&' equalityExpression
//        ;

//TODO andExpression '&' equalityExpression
public class AndExpression implements Node {

    private EqualityExpression equalityExpression;

    public AndExpression(String type, ScopeTable scopeTable) {
        this.equalityExpression = new EqualityExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(equalityExpression.produce());
    }
}
