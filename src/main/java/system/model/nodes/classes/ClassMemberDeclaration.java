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

    ClassMemberDeclaration(String type, ScopeTable scopeTable) {
        switch (type) {
            case "field":
                this.classMemberDeclaration = new FieldDeclaration(scopeTable);
                break;
            case "method":
                this.classMemberDeclaration = new MethodDeclaration(scopeTable);
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }

    }
////TODO join constructors
//    ClassMemberDeclaration(String type) {
//        switch (type) {
//            case "method":
//                this.classMemberDeclaration = new MethodDeclaration();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid type");
//        }
//    }

    public IClassMemberDeclaration getClassMemberDeclaration() {
        return classMemberDeclaration;
    }

    @Override
    public String produce() {
        return this.verify(classMemberDeclaration.produce());
    }
}
