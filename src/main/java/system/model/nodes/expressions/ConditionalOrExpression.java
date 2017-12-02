package system.model.nodes.expressions;

import system.model.nodes.Node;

//conditionalOrExpression
//        :	conditionalAndExpression
//        |	conditionalOrExpression '||' conditionalAndExpression
//        ;

//TODO conditionalOrExpression '||' conditionalAndExpression
public class ConditionalOrExpression implements Node {

    private ConditionalAndExpression conditionalAndExpression;

    public ConditionalOrExpression(String type) {
        this.conditionalAndExpression = new ConditionalAndExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(this.conditionalAndExpression.produce());
    }
}
