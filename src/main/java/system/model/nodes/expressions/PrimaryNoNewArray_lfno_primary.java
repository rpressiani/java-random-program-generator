package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.literals.Literal;

//primaryNoNewArray_lfno_primary
//        :	literal
//        |	typeName ('[' ']')* '.' 'class'
//        |	unannPrimitiveType ('[' ']')* '.' 'class'
//        |	'void' '.' 'class'
//        |	'this'
//        |	typeName '.' 'this'
//        |	'(' expression ')'
//        |	classInstanceCreationExpression_lfno_primary
//        |	fieldAccess_lfno_primary
//        |	arrayAccess_lfno_primary
//        |	methodInvocation_lfno_primary
//        |	methodReference_lfno_primary
//        ;

//TODO        |	typeName ('[' ']')* '.' 'class'
//TODO        |	unannPrimitiveType ('[' ']')* '.' 'class'
//TODO        |	'void' '.' 'class'
//TODO        |	'this'
//TODO        |	typeName '.' 'this'
//TODO        |	'(' expression ')'
//TODO        |	classInstanceCreationExpression_lfno_primary
//TODO        |	fieldAccess_lfno_primary
//TODO        |	arrayAccess_lfno_primary
//TODO        |	methodInvocation_lfno_primary
//TODO        |	methodReference_lfno_primary


public class PrimaryNoNewArray_lfno_primary implements Node{

    private Literal literal;

    PrimaryNoNewArray_lfno_primary(String type) {
        this.literal = new Literal(type);
    }

    @Override
    public String produce() {
        return this.verify(literal.produce());
    }
}
