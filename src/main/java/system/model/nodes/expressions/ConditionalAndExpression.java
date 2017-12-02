package system.model.nodes.expressions;

import system.model.nodes.Node;

//conditionalAndExpression
//        :	inclusiveOrExpression
//        |	conditionalAndExpression '&&' inclusiveOrExpression
//        ;

//TODO conditionalAndExpression '&&' inclusiveOrExpression
public class ConditionalAndExpression implements Node {

    private InclusiveOrExpression inclusiveOrExpression;

    public ConditionalAndExpression(String type) {
        this.inclusiveOrExpression = new InclusiveOrExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(inclusiveOrExpression.produce());
    }
}
