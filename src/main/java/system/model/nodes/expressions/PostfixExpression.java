package system.model.nodes.expressions;

import system.model.nodes.Node;

//postfixExpression
//        :	(	primary
//        |	expressionName
//        )
//        (	postIncrementExpression_lf_postfixExpression
//        |	postDecrementExpression_lf_postfixExpression
//        )*
//        ;

//TODO expressionName
//TODO postIncrementExpression_lf_postfixExpression
//TODO postDecrementExpression_lf_postfixExpression
//TODO WARNING!! * after post increment decrement postfix expression
public class PostfixExpression implements Node{

    private Primary primary;

    public PostfixExpression(String type) {
        this.primary = new Primary(type);
    }

    @Override
    public String produce() {
        return this.verify(primary.produce());
    }
}
