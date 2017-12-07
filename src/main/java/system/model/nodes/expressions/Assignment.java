package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.statements.IStatementExpression;

//assignment
//        :	leftHandSide assignmentOperator expression
//        ;

//TODO implement assignmentOperator

public class Assignment implements IStatementExpression {

    private LeftHandSide leftHandSide;
//    TODO Should be Expression
    private AdditiveExpression expression;

    public Assignment(ScopeTable scopeTable) {
        this.leftHandSide = new LeftHandSide(scopeTable);
        this.expression = new AdditiveExpression(
                new STKey(
                        this.leftHandSide.getExpressionName().getExpressionName().getType(),
                        scopeTable.isStaticScope()
                ),
                scopeTable
        );
    }

    @Override
    public String produce() {
        return this.verify(this.leftHandSide.produce() + "=" + this.expression.produce());
    }
}
