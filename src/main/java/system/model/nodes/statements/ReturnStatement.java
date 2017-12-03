package system.model.nodes.statements;

import system.model.ScopeTable;
import system.model.nodes.expressions.Expression;

//returnStatement
//        :	'return' expression? ';'
//        ;

public class ReturnStatement implements IStatementWithoutTrailingSubstatement {

    private String returnStatement;

    ReturnStatement(ScopeTable scopeTable, String type) {
            this.returnStatement = new Expression(type, scopeTable).produce();
    }

    @Override
    public String produce() {
        return this.verify("return " + returnStatement + ";");
    }
}
