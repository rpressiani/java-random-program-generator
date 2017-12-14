package system.model.nodes.classes;

//normalClassDeclaration
//        :	classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
//        ;

import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.identifiers.ClassIdentifier;

public class NormalClassDeclaration implements Node {

    private ClassIdentifier identifier;
    private ClassBody classBody;
    private ScopeTable scopeTable;

    public NormalClassDeclaration(boolean produceMain) {
        this.identifier = new ClassIdentifier();
        this.scopeTable = new ScopeTable();
        this.classBody = new ClassBody(scopeTable, produceMain);
    }

    public NormalClassDeclaration(String className, boolean produceMain) {
        this.identifier = new ClassIdentifier(className);
        this.scopeTable = new ScopeTable();
        this.classBody = new ClassBody(scopeTable, produceMain);
    }

    public NormalClassDeclaration(String className, ScopeTable scopeTable, boolean produceMain) {
        this.identifier = new ClassIdentifier(className);
        this.scopeTable = scopeTable;
        this.classBody = new ClassBody(new ScopeTable(scopeTable, true), produceMain);
    }

    @Override
    public String produce() {
        return this.verify("class " + this.identifier.produce() + classBody.produce());
    }

}
