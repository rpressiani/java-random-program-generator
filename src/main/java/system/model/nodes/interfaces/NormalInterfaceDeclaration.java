package system.model.nodes.interfaces;

//normalInterfaceDeclaration
//        :	interfaceModifier* 'interface' Identifier typeParameters? extendsInterfaces? interfaceBody
//        ;

import system.model.nodes.Node;
import system.model.nodes.identifiers.ClassIdentifier;

public class NormalInterfaceDeclaration implements Node{

    private InterfaceModifier interfaceModifier;
    private ClassIdentifier identifier;
    private InterfaceBody interfaceBody;

    NormalInterfaceDeclaration() {
        this.interfaceModifier = new InterfaceModifier();
        this.identifier = new ClassIdentifier();
        this.interfaceBody = new InterfaceBody();
    }

    public ClassIdentifier getIdentifier() {
        return identifier;
    }

    @Override
    public String produce() {
        return this.verify(this.interfaceModifier.produce() + " interface " + this.identifier.produce() + this.interfaceBody.produce());
    }
}
