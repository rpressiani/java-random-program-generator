package system.model.nodes.expressions;

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

    public MultiplicativeExpression(String type) {
        this.unaryExpression = new UnaryExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(unaryExpression.produce());
    }
}
