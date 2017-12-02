package system.model.nodes.expressions;

import system.model.nodes.Node;

//exclusiveOrExpression
//        :	andExpression
//        |	exclusiveOrExpression '^' andExpression
//        ;

//TODO exclusiveOrExpression '^' andExpression
public class ExclusiveOrExpression implements Node {

    private AndExpression andExpression;

    public ExclusiveOrExpression(String type) {
        this.andExpression = new AndExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(andExpression.produce());
    }
}
