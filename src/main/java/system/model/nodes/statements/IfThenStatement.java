package system.model.nodes.statements;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.expressions.Expression;

//ifThenStatement
//        :	'if' '(' expression ')' statement
//        ;

public class IfThenStatement implements IStatement {

    private Expression expression;
    private IStatement statement;

    IfThenStatement(STKey key, ScopeTable scopeTable) {
        this.expression = new Expression(new STKey("boolean", scopeTable.isStaticScope()) , scopeTable);
//        TODO Check grammar, ExpressionStatement must be substituted with Expression
        this.statement = new ExpressionStatement(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify("if (" + this.expression.produce() + ")" + this.statement.produce());
    }
}
