package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

//exclusiveOrExpression
//        :	andExpression
//        |	exclusiveOrExpression '^' andExpression
//        ;

public class ExclusiveOrExpression implements Node {

    private AndExpression andExpression;
    private ExclusiveOrExpression exclusiveOrExpression;

    private boolean unary;

    ExclusiveOrExpression(STKey key, ScopeTable scopeTable) {
        this.unary = (RandomGen.getNextInt(10) != 0);

        this.andExpression = new AndExpression(key, scopeTable);

        if (!this.unary) {
            this.exclusiveOrExpression = new ExclusiveOrExpression(key, scopeTable);
        }
    }

    @Override
    public String produce() {
        if (this.unary) {
            return this.verify(andExpression.produce());
        } else {
            String prod = this.exclusiveOrExpression.produce() + "^" + this.andExpression.produce();
            return this.verify(prod);
        }
    }
}
