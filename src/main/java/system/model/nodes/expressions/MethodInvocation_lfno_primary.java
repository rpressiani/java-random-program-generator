package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.literals.IPrimaryNoNewArray_lfno_primary;

//methodInvocation_lfno_primary
//        :	methodName '(' argumentList? ')'
//        |	typeName '.' typeArguments? Identifier '(' argumentList? ')'
//        |	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
//        |	'super' '.' typeArguments? Identifier '(' argumentList? ')'
//        |	typeName '.' 'super' '.' typeArguments? Identifier '(' argumentList? ')'
//        ;

//TODO        argumentList?
//TODO        |	typeName '.' typeArguments? Identifier '(' argumentList? ')'
//TODO        |	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
//TODO        |	'super' '.' typeArguments? Identifier '(' argumentList? ')'
//TODO        |	typeName '.' 'super' '.' typeArguments? Identifier '(' argumentList? ')'

public class MethodInvocation_lfno_primary implements IPrimaryNoNewArray_lfno_primary {

    private String methodName;

    MethodInvocation_lfno_primary(String type, ScopeTable scopeTable) {
        this.methodName = scopeTable.getRandomMethod(type).getIdentifier();
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append(methodName);
        b.append('(');
        b.append(')');
        return this.verify(b.toString());
    }

    public String getMethodName() {
        return methodName;
    }
}
