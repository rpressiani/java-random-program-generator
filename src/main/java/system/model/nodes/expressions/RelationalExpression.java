package system.model.nodes.expressions;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

//relationalExpression
//        :	shiftExpression
//        |	relationalExpression '<' shiftExpression
//        |	relationalExpression '>' shiftExpression
//        |	relationalExpression '<=' shiftExpression
//        |	relationalExpression '>=' shiftExpression
//        |	relationalExpression 'instanceof' referenceType
//        ;

//TODO relationalExpression 'instanceof' referenceType
public class RelationalExpression implements Node {

    private ShiftExpression shiftExpression;
    private RelationalExpression relationalExpression;

    private static List<String> operators =  new ArrayList<String>() {{
        add("<");
        add(">");
        add("<=");
        add(">=");
//        add("instanceof");
    }};
    private boolean unary;
    private String operator;

    RelationalExpression(STKey key, ScopeTable scopeTable) {
//        this.unary = (RandomGen.getNextInt(10) != 0);
//        TODO Manage non boolean types
        this.unary = true;

        this.shiftExpression = new ShiftExpression(key, scopeTable);

        if (!this.unary) {
            this.relationalExpression = new RelationalExpression(key, scopeTable);
            this.operator = this.operators.get(RandomGen.getNextInt(this.operators.size()));
        }
    }

    @Override
    public String produce() {
        if (this.unary) {
            return this.verify(shiftExpression.produce());
        } else {
            String prod = this.relationalExpression.produce() + this.operator + this.shiftExpression.produce();
            return this.verify(prod);
        }
    }
}
