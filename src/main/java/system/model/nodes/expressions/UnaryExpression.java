package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//unaryExpression
//        :	preIncrementExpression
//        |	preDecrementExpression
//        |	'+' unaryExpression
//        |	'-' unaryExpression
//        |	unaryExpressionNotPlusMinus
//        ;

//TODO preIncrementExpression
//TODO preDecrementExpression
//TODO '+' unaryExpression
//TODO '-' unaryExpression
public class UnaryExpression implements Node{

    private UnaryExpressionNotPlusMinus unaryExpressionNotPlusMinus;

    UnaryExpression(STKey key, ScopeTable scopeTable) {
        this.unaryExpressionNotPlusMinus = new UnaryExpressionNotPlusMinus(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(unaryExpressionNotPlusMinus.produce());
    }
}
