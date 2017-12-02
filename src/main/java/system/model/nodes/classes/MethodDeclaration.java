package system.model.nodes.classes;

import system.model.nodes.Node;

//methodDeclaration
//        :	methodModifier* methodHeader methodBody
//        ;

public class MethodDeclaration implements IClassMemberDeclaration {

    private MethodModifier methodModifier;
    private MethodHeader methodHeader;
    private MethodBody methodBody;

    MethodDeclaration() {
        this.methodModifier = new MethodModifier();
        this.methodHeader = new MethodHeader();
        this.methodBody = new MethodBody(this.methodHeader.getResult().getType());
    }

    public MethodModifier getMethodModifier() {
        return methodModifier;
    }

    public MethodHeader getMethodHeader() {
        return methodHeader;
    }

    @Override
    public String produce() {
        String b = methodModifier.produce() +
                " " +
                methodHeader.produce() +
                " " +
                methodBody.produce();
        return this.verify(b);
    }
}
