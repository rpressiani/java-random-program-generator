package system.model.nodes.expressions;

import system.model.STKey;
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

    RelationalExpression(STKey key, ScopeTable scopeTable) {
        this.shiftExpression = new ShiftExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(shiftExpression.produce());
    }
}
