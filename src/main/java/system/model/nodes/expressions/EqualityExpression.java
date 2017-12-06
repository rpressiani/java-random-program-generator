package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//equalityExpression
//        :	relationalExpression
//        |	equalityExpression '==' relationalExpression
//        |	equalityExpression '!=' relationalExpression
//        ;

//TODO equalityExpression '==' relationalExpression
//TODO equalityExpression '!=' relationalExpression
public class EqualityExpression implements Node {

    private RelationalExpression relationalExpression;

    EqualityExpression(STKey key, ScopeTable scopeTable) {
        this.relationalExpression = new RelationalExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(relationalExpression.produce());
    }
}
