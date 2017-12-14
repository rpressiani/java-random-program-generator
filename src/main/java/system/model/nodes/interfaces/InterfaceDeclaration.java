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

    @Override
    public String produce() {
        return this.verify(this.normalInterfaceDeclaration.produce());
    }

    public static void main(String[] args) {
        NormalInterfaceDeclaration normalClassDeclaration = new NormalInterfaceDeclaration();
        System.out.println(normalClassDeclaration.produce());
    }
}
