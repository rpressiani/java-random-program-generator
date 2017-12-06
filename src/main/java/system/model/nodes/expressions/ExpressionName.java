package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import utils.RandomGen;

//expressionName
//        :	Identifier
//        |	ambiguousName '.' Identifier
//        ;

//TODO        |	ambiguousName '.' Identifier

public class ExpressionName implements IPostfixExpression {

    private String expressionName;

    ExpressionName(STKey key, ScopeTable scopeTable) {
//            Logger.log("SCOPE TABLE", scopeTable.getLocalVariables().toString());
        if (RandomGen.getNextInt(2) == 1) {
            this.expressionName = scopeTable.getRandomVariable(key).getIdentifier();
        } else {
            this.expressionName = scopeTable.getRandomField(key).getIdentifier();
        }
//            Logger.logError("warning", this.expressionName);
    }

    @Override
    public String produce() {
        return this.verify(expressionName);
    }
}
