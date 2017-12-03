package system.model.nodes.expressions;

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

    public UnaryExpressionNotPlusMinus(String type, ScopeTable scopeTable) {
        this.postfixExpression = new PostfixExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(postfixExpression.produce());
    }
}
