package system.model.nodes.classes;

//variableDeclarator
//        :	variableDeclaratorId ('=' variableInitializer)?
//        ;

import system.model.nodes.Node;

//TODO implement variableInitializer
public class VariableDeclarator implements Node {

    private VariableDeclaratorId variableDeclaratorId;
    private VariableInitializer variableInitializer;

    VariableDeclarator(String type) {
        this.variableDeclaratorId = new VariableDeclaratorId();
        this.variableInitializer = new VariableInitializer(type);
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
            b.append("=" + initializer);
        }

        return this.verify(b.toString());
    }

}
