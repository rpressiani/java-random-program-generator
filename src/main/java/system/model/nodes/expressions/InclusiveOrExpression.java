package system.model.nodes.expressions;

import system.model.nodes.Node;

//inclusiveOrExpression
//        :	exclusiveOrExpression
//        |	inclusiveOrExpression '|' exclusiveOrExpression
//        ;

//TODO inclusiveOrExpression '|' exclusiveOrExpression
public class InclusiveOrExpression implements Node {

    private ExclusiveOrExpression exclusiveOrExpression;

    public InclusiveOrExpression(String type) {
        this.exclusiveOrExpression = new ExclusiveOrExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(exclusiveOrExpression.produce());
    }
}
