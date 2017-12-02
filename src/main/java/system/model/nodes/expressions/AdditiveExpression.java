package system.model.nodes.expressions;

import system.model.nodes.Node;

//additiveExpression
//        :	multiplicativeExpression
//        |	additiveExpression '+' multiplicativeExpression
//        |	additiveExpression '-' multiplicativeExpression
//        ;

//TODO additiveExpression '+' multiplicativeExpression
//TODO additiveExpression '-' multiplicativeExpression
public class AdditiveExpression implements Node
{

    private MultiplicativeExpression multiplicativeExpression;

    public AdditiveExpression(String type) {
        this.multiplicativeExpression = new MultiplicativeExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(multiplicativeExpression.produce());
    }
}
