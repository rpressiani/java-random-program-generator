package system.model.nodes.expressions;

import system.model.nodes.Node;

//conditionalExpression
//        :	conditionalOrExpression
//        |	conditionalOrExpression '?' expression ':' conditionalExpression
//        ;

//TODO conditionalOrExpression '?' expression ':' conditionalExpression
public class ConditionalExpression implements Node {

    private ConditionalOrExpression conditionalOrExpression;

    public ConditionalExpression(String type) {
        this.conditionalOrExpression = new ConditionalOrExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(conditionalOrExpression.produce());
    }
}
