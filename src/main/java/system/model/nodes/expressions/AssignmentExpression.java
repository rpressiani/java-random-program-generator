package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//assignmentExpression
//        :	conditionalExpression
//        |	assignment
//        ;

//TODO assignment
public class AssignmentExpression implements Node {

    private ConditionalExpression conditionalExpression;

    AssignmentExpression(STKey key, ScopeTable scopeTable) {
        this.conditionalExpression = new ConditionalExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(conditionalExpression.produce());
    }
}
