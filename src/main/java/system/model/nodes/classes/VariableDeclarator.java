package system.model.nodes.classes;

//variableDeclarator
//        :	variableDeclaratorId ('=' variableInitializer)?
//        ;

import system.model.nodes.Node;

public class VariableDeclarator implements Node {

    private VariableDeclaratorId variableDeclaratorId;

    VariableDeclarator() {
        this.variableDeclaratorId = new VariableDeclaratorId();
    }

    @Override
    public String produce() {
        return this.verify(this.variableDeclaratorId.produce());
    }
}
