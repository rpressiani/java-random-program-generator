package system.model.nodes.expressions;

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

    public MultiplicativeExpression(String type, ScopeTable scopeTable) {
        this.unaryExpression = new UnaryExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(unaryExpression.produce());
    }
}
