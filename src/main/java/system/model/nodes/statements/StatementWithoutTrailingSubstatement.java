package system.model.nodes.statements;

//statementWithoutTrailingSubstatement
//        :	block
//        |	emptyStatement
//        |	expressionStatement
//        |	assertStatement
//        |	switchStatement
//        |	doStatement
//        |	breakStatement
//        |	continueStatement
//        |	returnStatement
//        |	synchronizedStatement
//        |	throwStatement
//        |	tryStatement
//        ;

import system.model.ScopeTable;

public class StatementWithoutTrailingSubstatement implements IStatement {

    private IStatementWithoutTrailingSubstatement statementWithoutTrailingSubstatement;

    StatementWithoutTrailingSubstatement(ScopeTable scopeTable, String type) {
        this.statementWithoutTrailingSubstatement = new ReturnStatement(scopeTable, type);
    }

    @Override
    public String produce() {
        return this.verify(statementWithoutTrailingSubstatement.produce());
    }
}
