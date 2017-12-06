package system.model.nodes.classes;

//methodDeclaration
//        :	methodModifier* methodHeader methodBody
//        ;

import system.model.STEntry;
import system.model.STKey;
import system.model.ScopeTable;

public class MethodDeclaration implements IClassMemberDeclaration {

    private MethodModifier methodModifier;
    private MethodHeader methodHeader;
    private MethodBody methodBody;

    MethodDeclaration(ScopeTable outerScopeTable) {
        ScopeTable scopeTable = new ScopeTable(outerScopeTable);

        this.methodModifier = new MethodModifier();
        this.methodHeader = new MethodHeader();
        this.methodBody = new MethodBody(new STKey(this.methodHeader.getResult().getType(), false), scopeTable);

        outerScopeTable.addMethod(
                this.methodHeader.getResult().getType(),
                new STEntry(this.methodHeader.getMethodDeclarator().getIdentifier().toString(), false)
        );
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
