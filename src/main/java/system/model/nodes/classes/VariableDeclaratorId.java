package system.model.nodes.classes;

//variableDeclaratorId
//        :	Identifier dims?
//        ;

import system.model.nodes.Node;
import system.model.nodes.identifiers.GenericIdentifier;

//TODO implement "dims?"
public class VariableDeclaratorId implements Node {
    private GenericIdentifier genericIdentifier;

    VariableDeclaratorId() {
        this.genericIdentifier = new GenericIdentifier();
    }

    public String getId() {
        return genericIdentifier.toString();
    }

    @Override
    public String produce() {
        return this.verify(this.genericIdentifier.produce());
    }
}
