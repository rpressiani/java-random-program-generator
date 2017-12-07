package system.model.nodes.statements;

import system.model.STKey;
import system.model.ScopeTable;

public class MethodInvocation implements IStatementExpression {

    private String methodName;

    MethodInvocation(ScopeTable scopeTable) {
        this.methodName = scopeTable.getRandomMethod(new STKey(null, scopeTable.isStaticScope())).getIdentifier();
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public String produce() {
        return this.verify(methodName + "()");
    }
}
