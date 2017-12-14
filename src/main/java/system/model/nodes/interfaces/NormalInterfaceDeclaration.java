package system.model.nodes.interfaces;

//normalInterfaceDeclaration
//        :	interfaceModifier* 'interface' Identifier typeParameters? extendsInterfaces? interfaceBody
//        ;

import system.model.nodes.Node;
import system.model.nodes.identifiers.GenericIdentifier;

public class NormalInterfaceDeclaration implements Node{

    private InterfaceModifier interfaceModifier;
    private GenericIdentifier identifier;
    private InterfaceBody interfaceBody;

    NormalInterfaceDeclaration() {
        this.interfaceModifier = new InterfaceModifier();
        this.identifier = new GenericIdentifier();
        this.interfaceBody = new InterfaceBody();
    }

    @Override
    public String produce() {
        return this.verify(this.interfaceModifier.produce() + " interface " + this.interfaceBody.produce());
    }
}
