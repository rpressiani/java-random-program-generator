package system.model.nodes.interfaces;

import system.model.nodes.Node;
import system.model.nodes.classes.NormalClassDeclaration;

//interfaceDeclaration
//        :	normalInterfaceDeclaration
//        |	annotationTypeDeclaration
//        ;

public class InterfaceDeclaration implements Node {

    private NormalInterfaceDeclaration normalInterfaceDeclaration;

    public InterfaceDeclaration() {
        this.normalInterfaceDeclaration = new NormalInterfaceDeclaration();
    }

    public NormalInterfaceDeclaration getNormalInterfaceDeclaration() {
        return normalInterfaceDeclaration;
    }

    @Override
    public String produce() {
        return this.verify(this.normalInterfaceDeclaration.produce());
    }

}
