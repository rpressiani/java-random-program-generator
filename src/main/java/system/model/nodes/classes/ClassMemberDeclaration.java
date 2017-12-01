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

    private FieldDeclaration fieldDeclaration;

    ClassMemberDeclaration() {
        this.fieldDeclaration = new FieldDeclaration();
    }

    public FieldDeclaration getFieldDeclaration() {
        return fieldDeclaration;
    }

    @Override
    public String produce() {
        return this.verify(fieldDeclaration.produce());
    }
}
