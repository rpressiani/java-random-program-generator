package system.model.nodes.statements;

import system.model.STKey;
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

    Statement(STKey key, ScopeTable scopeTable) {
//        this.statement = new StatementWithoutTrailingSubstatement(scopeTable, key);
        this.statement = new IfThenStatement(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
