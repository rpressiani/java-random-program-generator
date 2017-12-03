package system.model.nodes.classes;

import system.model.nodes.Node;

//methodHeader
//        :	result methodDeclarator throws_?
//        |	typeParameters annotation* result methodDeclarator throws_?
//        ;

//TODO throws_?
//TODO typeParameters annotation* result methodDeclarator throws_?

public class MethodHeader implements Node{

    private Result result;
    private MethodDeclarator methodDeclarator;

    MethodHeader() {
        this.result = new Result();
        this.methodDeclarator = new MethodDeclarator();
    }

    public Result getResult() {
        return result;
    }

    public MethodDeclarator getMethodDeclarator() {
        return methodDeclarator;
    }

    @Override
    public String produce() {
        String b = result.produce() +
                " " +
                methodDeclarator.produce() +
                " ";
        return this.verify(b);
    }
}
