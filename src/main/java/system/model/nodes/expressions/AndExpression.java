package system.model.nodes.expressions;

import system.model.nodes.Node;

//andExpression
//        :	equalityExpression
//        |	andExpression '&' equalityExpression
//        ;

//TODO andExpression '&' equalityExpression
public class AndExpression implements Node {

    private EqualityExpression equalityExpression;

    public AndExpression(String type) {
        this.equalityExpression = new EqualityExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(equalityExpression.produce());
    }
}
