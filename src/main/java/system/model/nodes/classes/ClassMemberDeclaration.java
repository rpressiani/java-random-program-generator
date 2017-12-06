package system.model.nodes.classes;

import system.model.ScopeTable;
import system.model.nodes.Node;

//classMemberDeclaration
//        :	fieldDeclaration
//        |	methodDeclaration
//        |	classDeclaration
//        |	interfaceDeclaration
//        |	';'
//        ;

public class ClassMemberDeclaration implements Node {

    private IClassMemberDeclaration classMemberDeclaration;

    ClassMemberDeclaration(String memberType, ScopeTable scopeTable) {
        switch (memberType) {
            case "field":
                this.classMemberDeclaration = new FieldDeclaration(scopeTable, memberType);
                break;
            case "method":
                this.classMemberDeclaration = new MethodDeclaration(scopeTable);
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }

    }

    @Override
    public String produce() {
        return this.verify(classMemberDeclaration.produce());
    }
}
