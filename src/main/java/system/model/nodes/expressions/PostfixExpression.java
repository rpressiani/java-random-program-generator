package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

//postfixExpression
//        :	(	primary
//        |	expressionName
//        )
//        (	postIncrementExpression_lf_postfixExpression
//        |	postDecrementExpression_lf_postfixExpression
//        )*
//        ;

//TODO postIncrementExpression_lf_postfixExpression
//TODO postDecrementExpression_lf_postfixExpression
//TODO WARNING!! * after post increment decrement postfix expression
public class PostfixExpression implements Node{

    private IPostfixExpression postfixExpression;

    PostfixExpression(String type, ScopeTable scopeTable) {
        if (RandomGen.getNextInt(2) == 1) {
            this.postfixExpression = new Primary(type, scopeTable);
        } else {
            this.postfixExpression = new ExpressionName(type, scopeTable);
            if (this.postfixExpression.produce() == null) {
                this.postfixExpression = new Primary(type, scopeTable);
            }
        }


    }

    @Override
    public String produce() {
        return this.verify(postfixExpression.produce());
    }

}
