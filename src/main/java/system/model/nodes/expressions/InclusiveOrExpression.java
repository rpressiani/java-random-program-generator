package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

//inclusiveOrExpression
//        :	exclusiveOrExpression
//        |	inclusiveOrExpression '|' exclusiveOrExpression
//        ;

public class InclusiveOrExpression implements Node {

    private ExclusiveOrExpression exclusiveOrExpression;
    private InclusiveOrExpression inclusiveOrExpression;

    private boolean unary;

    InclusiveOrExpression(STKey key, ScopeTable scopeTable) {
        this.unary = (RandomGen.getNextInt(10) != 0);

        this.exclusiveOrExpression = new ExclusiveOrExpression(key, scopeTable);

        if (!this.unary) {
            this.inclusiveOrExpression = new InclusiveOrExpression(key, scopeTable);
        }
    }

    @Override
    public String produce() {
        if (this.unary) {
            return this.verify(exclusiveOrExpression.produce());
        } else {
            String prod = this.inclusiveOrExpression.produce() + "|" + this.exclusiveOrExpression.produce();
            return this.verify(prod);
        }
    }
}
