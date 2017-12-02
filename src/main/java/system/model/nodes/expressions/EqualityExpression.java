package system.model.nodes.expressions;

import system.model.nodes.Node;

//equalityExpression
//        :	relationalExpression
//        |	equalityExpression '==' relationalExpression
//        |	equalityExpression '!=' relationalExpression
//        ;

//TODO equalityExpression '==' relationalExpression
//TODO equalityExpression '!=' relationalExpression
public class EqualityExpression implements Node {

    private RelationalExpression relationalExpression;

    public EqualityExpression(String type) {
        this.relationalExpression = new RelationalExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(relationalExpression.produce());
    }
}
