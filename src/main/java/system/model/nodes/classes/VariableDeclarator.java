package system.model.nodes.classes;

//variableDeclarator
//        :	variableDeclaratorId ('=' variableInitializer)?
//        ;

import system.model.nodes.Node;

//TODO implement variableInitializer
public class VariableDeclarator implements Node {

    private VariableDeclaratorId variableDeclaratorId;

    VariableDeclarator() {
        this.variableDeclaratorId = new VariableDeclaratorId();
    }

    public String getVariableDeclaratorId() {
        return variableDeclaratorId.getId();
    }

    @Override
    public String produce() {
        return this.verify(this.variableDeclaratorId.produce());
    }

}
