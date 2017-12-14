package system.model.nodes.classes;

import system.model.STEntry;
import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

public class OverriddenMethod implements Node {

    private MethodBody methodBody;
    private STEntry params;

    OverriddenMethod(STEntry params, ScopeTable scopeTable) {
        this.params = params;
        this.methodBody = new MethodBody(new STKey(params.getType(), false), scopeTable);
    }

    @Override
    public String produce() {
        return this.verify("@Override public " + this.params.getType() + " " + this.params.getIdentifier() + "() " + this.methodBody.produce());
    }
}
