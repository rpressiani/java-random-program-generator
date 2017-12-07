package system.model.nodes.statements;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.expressions.AdditiveExpression;

//returnStatement
//        :	'return' expression? ';'
//        ;

public class ReturnStatement implements IStatementWithoutTrailingSubstatement {

    private String returnStatement;

    ReturnStatement(ScopeTable scopeTable, STKey key) {
//        TODO Should be Expression
        this.returnStatement = new AdditiveExpression(key, scopeTable).produce();
    }

    @Override
    public String produce() {
        return this.verify("return " + returnStatement + ";");
    }
}
