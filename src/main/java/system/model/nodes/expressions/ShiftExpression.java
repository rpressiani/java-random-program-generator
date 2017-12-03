package system.model.nodes.expressions;

import system.model.ScopeTable;
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

    public ShiftExpression(String type, ScopeTable scopeTable) {
        this.additiveExpression = new AdditiveExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(additiveExpression.produce());
    }
}
