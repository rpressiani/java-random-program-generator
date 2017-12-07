package system.model.nodes.expressions;

//leftHandSide
//	:	expressionName
//	|	fieldAccess
//	|	arrayAccess
//	;

import system.model.ScopeTable;
import system.model.nodes.Node;

public class LeftHandSide implements Node {

    private ExpressionName expressionName;

    LeftHandSide(ScopeTable scopeTable) {
        this.expressionName = new ExpressionName(scopeTable);
    }

    public ExpressionName getExpressionName() {
        return expressionName;
    }

    @Override
    public String produce() {
        return this.verify(this.expressionName.produce());
    }
}
