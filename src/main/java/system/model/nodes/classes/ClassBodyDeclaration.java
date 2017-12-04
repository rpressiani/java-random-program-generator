package system.model.nodes.classes;

import system.model.ScopeTable;
import system.model.nodes.Node;

//classBodyDeclaration
//        :	classMemberDeclaration
//        |	instanceInitializer
//        |	staticInitializer
//        |	constructorDeclaration
//        ;

public class ClassBodyDeclaration implements Node {

    private ClassMemberDeclaration classMemberDeclaration;

    ClassBodyDeclaration(String type, ScopeTable scopeTable) {
        this.classMemberDeclaration = new ClassMemberDeclaration(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(this.classMemberDeclaration.produce());
    }
}
