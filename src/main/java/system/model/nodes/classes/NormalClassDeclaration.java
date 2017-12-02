package system.model.nodes.classes;

//normalClassDeclaration
//        :	classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
//        ;

import system.model.nodes.Node;
import system.model.nodes.identifiers.ClassIdentifier;

public class NormalClassDeclaration implements Node {

    private ClassIdentifier identifier;
    private ClassBody classBody;

    public NormalClassDeclaration() {
        this.identifier = new ClassIdentifier();
        this.classBody = new ClassBody();
    }

    public NormalClassDeclaration(String className) {
        this.identifier = new ClassIdentifier(className);
        this.classBody = new ClassBody();
    }

    @Override
    public String produce() {
        return this.verify("class " + this.identifier.produce() + classBody.produce());
    }

}
