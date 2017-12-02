package system.model.nodes.expressions;

import system.model.nodes.Node;

//assignmentExpression
//        :	conditionalExpression
//        |	assignment
//        ;

//TODO assignment
public class AssignmentExpression implements Node {

    private ConditionalExpression conditionalExpression;

    public AssignmentExpression(String type) {
        this.conditionalExpression = new ConditionalExpression(type);
    }

    @Override
    public String produce() {
        return this.verify(conditionalExpression.produce());
    }
}
