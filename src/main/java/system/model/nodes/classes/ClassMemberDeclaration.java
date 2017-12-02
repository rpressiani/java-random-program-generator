package system.model.nodes.classes;

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

    ClassMemberDeclaration(String type) {
        switch (type) {
            case "field":
                this.classMemberDeclaration = new FieldDeclaration();
                break;
            case "method":
                this.classMemberDeclaration = new MethodDeclaration();
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }

    }

    public IClassMemberDeclaration getClassMemberDeclaration() {
        return classMemberDeclaration;
    }

    @Override
    public String produce() {
        return this.verify(classMemberDeclaration.produce());
    }
}
