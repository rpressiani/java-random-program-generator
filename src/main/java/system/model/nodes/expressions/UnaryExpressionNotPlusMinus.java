package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//unaryExpressionNotPlusMinus
//        :	postfixExpression
//        |	'~' unaryExpression
//        |	'!' unaryExpression
//        |	castExpression
//        ;

//TODO '~' unaryExpression
//TODO '!' unaryExpression
//TODO castExpression
public class UnaryExpressionNotPlusMinus implements Node{

    private PostfixExpression postfixExpression;

    public UnaryExpressionNotPlusMinus(STKey key, ScopeTable scopeTable) {
        this.postfixExpression = new PostfixExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(postfixExpression.produce());
    }
}
