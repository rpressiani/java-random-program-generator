package system.model.nodes.statements;

//expressionStatement
//        :	statementExpression ';'
//        ;

import system.model.STKey;
import system.model.ScopeTable;

public class ExpressionStatement implements IStatement {

    private StatementExpression statementExpression;

    ExpressionStatement(STKey key, ScopeTable scopeTable) {
        this.statementExpression = new StatementExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(this.statementExpression.produce() + ";");
    }
}
