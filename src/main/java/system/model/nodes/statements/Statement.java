package system.model.nodes.statements;

import system.model.nodes.Node;

//statement
//        :	statementWithoutTrailingSubstatement
//        |	labeledStatement
//        |	ifThenStatement
//        |	ifThenElseStatement
//        |	whileStatement
//        |	forStatement
//        ;

public class Statement implements IStatement{

    private IStatement statement;

    Statement(String type) {
        this.statement = new StatementWithoutTrailingSubstatement(type);
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
