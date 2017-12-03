package system.model.nodes.statements;

import system.model.ScopeTable;

//statement
//        :	statementWithoutTrailingSubstatement
//        |	labeledStatement
//        |	ifThenStatement
//        |	ifThenElseStatement
//        |	whileStatement
//        |	forStatement
//        ;

//TODO        |	labeledStatement
//TODO        |	ifThenStatement
//TODO        |	ifThenElseStatement
//TODO        |	whileStatement
//TODO        |	forStatement

public class Statement implements IBlockStatement{

    private IStatement statement;

//    Statement() {
//
//    }

    Statement(String type, ScopeTable scopeTable) {
        this.statement = new StatementWithoutTrailingSubstatement(scopeTable, type);
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
