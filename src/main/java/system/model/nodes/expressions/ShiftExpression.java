package system.model.nodes.expressions;

import system.model.nodes.Node;

//shiftExpression
//        :	additiveExpression
//        |	shiftExpression '<' '<' additiveExpression
//        |	shiftExpression '>' '>' additiveExpression
//        |	shiftExpression '>' '>' '>' additiveExpression
//        ;

//TODO shiftExpression '<' '<' additiveExpression
//TODO shiftExpression '>' '>' additiveExpression
//TODO shiftExpression '>' '>' '>' additiveExpression
public class ShiftExpression implements Node {

    private AdditiveExpression additiveExpression;

    public ShiftExpression(String type) {
        this.additiveExpression = new AdditiveExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(additiveExpression.produce());
    }
}
