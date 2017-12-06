package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//multiplicativeExpression
//        :	unaryExpression
//        |	multiplicativeExpression '*' unaryExpression
//        |	multiplicativeExpression '/' unaryExpression
//        |	multiplicativeExpression '%' unaryExpression
//        ;

//TODO multiplicativeExpression '*' unaryExpression
//TODO multiplicativeExpression '/' unaryExpression
//TODO multiplicativeExpression '%' unaryExpression
public class MultiplicativeExpression implements Node{

    private UnaryExpression unaryExpression;

    MultiplicativeExpression(STKey key, ScopeTable scopeTable) {
        this.unaryExpression = new UnaryExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(unaryExpression.produce());
    }
}
