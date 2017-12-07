package system.model.nodes.statements;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.expressions.Assignment;

//statementExpression
//        :	assignment
//        |	preIncrementExpression
//        |	preDecrementExpression
//        |	postIncrementExpression
//        |	postDecrementExpression
//        |	methodInvocation
//        |	classInstanceCreationExpression
//        ;

public class StatementExpression implements IStatement{

    private IStatementExpression statementExpression;

    StatementExpression(STKey key, ScopeTable scopeTable) {
        this.statementExpression = new MethodInvocation(scopeTable);
        if (((MethodInvocation) this.statementExpression).getMethodName() == null) {
            this.statementExpression = new Assignment(scopeTable);
        }
    }

    @Override
    public String produce() {
        return this.verify(statementExpression.produce());
    }
}
