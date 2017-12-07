package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.Random;

//equalityExpression
//        :	relationalExpression
//        |	equalityExpression '==' relationalExpression
//        |	equalityExpression '!=' relationalExpression
//        ;

public class EqualityExpression implements Node {

    private RelationalExpression relationalExpression;
    private EqualityExpression equalityExpression;
    private String operator;

    private boolean unary;

    EqualityExpression(STKey key, ScopeTable scopeTable) {
        this.unary = (RandomGen.getNextInt(10) != 0);

        this.relationalExpression = new RelationalExpression(key, scopeTable);

        if (!this.unary) {
            this.equalityExpression = new EqualityExpression(key, scopeTable);
            this.operator = new Random().nextBoolean() ? "==" : "!=";
        }
    }

    @Override
    public String produce() {
        if (this.unary) {
            return this.verify(relationalExpression.produce());
        } else {
            String prod = this.equalityExpression.produce() + this.operator + this.relationalExpression.produce();
            return this.verify(prod);
        }
    }
}
