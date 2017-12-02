package system.model.nodes.expressions;

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

    public UnaryExpression(String type) {
        this.unaryExpressionNotPlusMinus = new UnaryExpressionNotPlusMinus(type);
    }

    @Override
    public String produce() {
        return this.verify(unaryExpressionNotPlusMinus.produce());
    }
}
