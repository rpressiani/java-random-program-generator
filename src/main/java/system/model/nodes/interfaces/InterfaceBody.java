package system.model.nodes.interfaces;

import system.model.nodes.Node;

//interfaceBody
//        :	'{' interfaceMemberDeclaration* '}'
//        ;

public class InterfaceBody implements Node {

    private InterfaceMemberDeclaration interfaceMemberDeclaration;

    InterfaceBody() {
        this.interfaceMemberDeclaration = new InterfaceMemberDeclaration();
    }

    @Override
    public String produce() {
        return this.verify("{" + this.interfaceMemberDeclaration.produce() + "}");
    }
}
