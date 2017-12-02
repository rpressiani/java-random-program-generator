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

public class StatementWithoutTrailingSubstatement implements IStatement {

    private IStatementWithoutTrailingSubstatement statementWithoutTrailingSubstatement;

    StatementWithoutTrailingSubstatement(String type) {
        this.statementWithoutTrailingSubstatement = new ReturnStatement(type);
    }

    @Override
    public String produce() {
        return this.verify(statementWithoutTrailingSubstatement.produce());
    }
}
