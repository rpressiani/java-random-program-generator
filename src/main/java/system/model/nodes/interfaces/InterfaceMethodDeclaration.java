package system.model.nodes.interfaces;

import system.model.nodes.Node;
import system.model.nodes.classes.MethodHeader;

//interfaceMethodDeclaration
//        :	interfaceMethodModifier* methodHeader methodBody
//        ;

public class InterfaceMethodDeclaration implements Node{

    private InterfaceMethodModifier interfaceMethodModifier;
    private MethodHeader methodHeader;

    InterfaceMethodDeclaration() {
        this.interfaceMethodModifier = new InterfaceMethodModifier();
        this.methodHeader = new MethodHeader();
    }

    @Override
    public String produce() {
        return this.verify(this.interfaceMethodModifier.produce() + " " + this.methodHeader.produce() + ";");
    }
}
