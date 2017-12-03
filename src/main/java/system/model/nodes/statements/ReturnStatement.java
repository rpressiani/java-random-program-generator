package system.model.nodes.statements;

import system.model.ScopeTable;
import system.model.nodes.literals.Literal;

//returnStatement
//        :	'return' expression? ';'
//        ;

//TODO implement expression

public class ReturnStatement implements IStatementWithoutTrailingSubstatement {

    private String returnStatement;

    ReturnStatement(ScopeTable scopeTable, String type) {
//        TODO implement return from scopeTable
        this.returnStatement = new Literal(type).produce();
    }

    @Override
    public String produce() {
        return this.verify("return " + returnStatement + ";");
    }
}
