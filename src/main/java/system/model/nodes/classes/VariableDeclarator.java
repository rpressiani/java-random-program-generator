package system.model.nodes.classes;

//variableDeclarator
//        :	variableDeclaratorId ('=' variableInitializer)?
//        ;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//TODO all variable are always initilized
public class VariableDeclarator implements Node {

    private VariableDeclaratorId variableDeclaratorId;
    private VariableInitializer variableInitializer;

    VariableDeclarator(STKey key, ScopeTable scopeTable) {
        this.variableDeclaratorId = new VariableDeclaratorId();
        this.variableInitializer = new VariableInitializer(key, scopeTable);
    }

    public String getVariableDeclaratorId() {
        return variableDeclaratorId.getId();
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();

        b.append(this.variableDeclaratorId.produce());
        String initializer = this.variableInitializer.produce();
        if (initializer.length() > 0) {
            b.append("=").append(initializer);
        }

        return this.verify(b.toString());
    }

}
