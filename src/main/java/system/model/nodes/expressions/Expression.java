package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//expression
//        :	lambdaExpression
//        |	assignmentExpression
//        ;

//TODO implement lambdaExpression
public class Expression implements Node {

    private AssignmentExpression assignmentExpression;

    public Expression(STKey key, ScopeTable scopeTable) {
        this.assignmentExpression = new AssignmentExpression(key, scopeTable);
    }

    public AssignmentExpression getAssignmentExpression() {
        return assignmentExpression;
    }

    public String produce() {
        return this.verify(this.assignmentExpression.produce());
    }
}
