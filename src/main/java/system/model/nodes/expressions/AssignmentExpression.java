package system.model.nodes.expressions;

import system.model.ScopeTable;
import system.model.nodes.Node;

//assignmentExpression
//        :	conditionalExpression
//        |	assignment
//        ;

//TODO assignment
public class AssignmentExpression implements Node {

    private ConditionalExpression conditionalExpression;

    AssignmentExpression(String type, ScopeTable scopeTable) {
        this.conditionalExpression = new ConditionalExpression(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(conditionalExpression.produce());
    }
}
