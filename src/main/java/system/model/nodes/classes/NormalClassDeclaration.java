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

    public NormalClassDeclaration() {
        this.identifier = new ClassIdentifier();
        this.scopeTable = new ScopeTable();
        this.classBody = new ClassBody(scopeTable);
    }

    public NormalClassDeclaration(String className) {
        this.identifier = new ClassIdentifier(className);
        this.scopeTable = new ScopeTable();
        this.classBody = new ClassBody(scopeTable);
    }

    public NormalClassDeclaration(String className, ScopeTable scopeTable) {
        this.identifier = new ClassIdentifier(className);
        this.scopeTable = scopeTable;
        this.classBody = new ClassBody(new ScopeTable(scopeTable, true));
    }

    @Override
    public String produce() {
        return this.verify("class " + this.identifier.produce() + classBody.produce());
    }

}
