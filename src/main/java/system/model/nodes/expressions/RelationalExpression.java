package system.model.nodes.expressions;

import system.model.nodes.Node;

//relationalExpression
//        :	shiftExpression
//        |	relationalExpression '<' shiftExpression
//        |	relationalExpression '>' shiftExpression
//        |	relationalExpression '<=' shiftExpression
//        |	relationalExpression '>=' shiftExpression
//        |	relationalExpression 'instanceof' referenceType
//        ;

//TODO relationalExpression '<' shiftExpression
//TODO relationalExpression '>' shiftExpression
//TODO relationalExpression '<=' shiftExpression
//TODO relationalExpression '>=' shiftExpression
//TODO relationalExpression 'instanceof' referenceType
public class RelationalExpression implements Node {

    private ShiftExpression shiftExpression;

    public RelationalExpression(String type) {
        this.shiftExpression = new ShiftExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(shiftExpression.produce());
    }
}
