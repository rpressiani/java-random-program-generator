package system.model.nodes.expressions;

import system.model.nodes.Node;

//expression
//        :	lambdaExpression
//        |	assignmentExpression
//        ;

//TODO implement lambdaExpression
public class Expression implements Node {

    private AssignmentExpression assignmentExpression;

    public Expression(String type) {
        this.assignmentExpression = new AssignmentExpression(type);
    }

    public AssignmentExpression getAssignmentExpression() {
        return assignmentExpression;
    }

    public String produce() {
        return this.verify(this.assignmentExpression.produce());
    }
}
