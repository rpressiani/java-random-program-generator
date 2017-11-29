package system.model.nodes.classes;

//classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody

import system.model.nodes.Node;
import system.model.nodes.identifiers.ClassIdentifier;

public class NormalClassDeclaration implements Node {

    private ClassIdentifier identifier;
    private Classbody classbody;

    public NormalClassDeclaration() {
        this.identifier = new ClassIdentifier();
        this.classbody = new Classbody();
    }


    @Override
    public String produce() {
        return this.verify("class " + this.identifier.produce() + classbody.produce());
    }

}
