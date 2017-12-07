package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//additiveExpression
//        :	multiplicativeExpression
//        |	additiveExpression '+' multiplicativeExpression
//        |	additiveExpression '-' multiplicativeExpression
//        ;

//TODO additiveExpression '+' multiplicativeExpression
//TODO additiveExpression '-' multiplicativeExpression
public class AdditiveExpression implements Node
{

    private MultiplicativeExpression multiplicativeExpression;

    public AdditiveExpression(STKey key, ScopeTable scopeTable) {
        this.multiplicativeExpression = new MultiplicativeExpression(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(multiplicativeExpression.produce());
    }
}
