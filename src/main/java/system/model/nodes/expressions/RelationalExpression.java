package system.model.nodes.expressions;

import system.model.ScopeTable;
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

    public RelationalExpression(String type, ScopeTable scopeTable) {
        this.shiftExpression = new ShiftExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(shiftExpression.produce());
    }
}
