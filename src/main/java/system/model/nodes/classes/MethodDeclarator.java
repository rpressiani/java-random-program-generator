package system.model.nodes.classes;

import system.model.nodes.Node;
import system.model.nodes.identifiers.GenericIdentifier;

//methodDeclarator
//        :	Identifier '(' formalParameterList? ')' dims?
//        ;

//TODO '(' formalParameterList? ')' dims?

public class MethodDeclarator implements Node{

    private GenericIdentifier identifier;

    MethodDeclarator() {
        this.identifier = new GenericIdentifier();
    }

    public GenericIdentifier getIdentifier() {
        return identifier;
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append(identifier.produce());
        b.append("(");
        b.append(")");
        return this.verify(b.toString());
    }
}
