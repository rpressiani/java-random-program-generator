package system.model.nodes.expressions;

import system.model.ScopeTable;
import utils.RandomGen;

//expressionName
//        :	Identifier
//        |	ambiguousName '.' Identifier
//        ;

//TODO        |	ambiguousName '.' Identifier

public class ExpressionName implements IPostfixExpression {

    private String expressionName;

    ExpressionName(String type, ScopeTable scopeTable) {
//            Logger.log("SCOPE TABLE", scopeTable.getLocalVariables().toString());
        if (RandomGen.getNextInt(2) == 1) {
            this.expressionName = scopeTable.getRandomVariable(type).getIdentifier();
        } else {
            this.expressionName = scopeTable.getRandomField(type).getIdentifier();
        }
//            Logger.logError("warning", this.expressionName);
    }

    @Override
    public String produce() {
        return this.verify(expressionName);
    }
}
