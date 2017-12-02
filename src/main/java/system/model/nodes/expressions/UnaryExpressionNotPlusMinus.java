package system.model.nodes.expressions;

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

    public UnaryExpressionNotPlusMinus(String type) {
        this.postfixExpression = new PostfixExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(postfixExpression.produce());
    }
}
