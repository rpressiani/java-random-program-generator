package system.model.nodes.expressions;

import system.model.ScopeTable;

public class ExpressionName implements IPostfixExpression {

    private String expressionName;

    ExpressionName(String type, ScopeTable scopeTable) {
//            Logger.log("SCOPE TABLE", scopeTable.getLocalVariables().toString());
            this.expressionName = scopeTable.getRandomVariable(type);
//            Logger.logError("warning", this.expressionName);
    }

    @Override
    public String produce() {
        return this.verify(expressionName);
    }
}
