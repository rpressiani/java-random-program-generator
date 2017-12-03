package system.model.nodes.statements;

import system.model.ScopeTable;
import system.model.nodes.Node;

//block
//        :	'{' blockStatements? '}'
//        ;

//TODO ?

public class Block implements Node{

    private BlockStatements blockStatements;
    private ScopeTable scopeTable;

    public Block(String type) {
        this.scopeTable = new ScopeTable();
        this.blockStatements = new BlockStatements(type, this.scopeTable);
    }

    public Block(ScopeTable outerScopeTable) {
        this.scopeTable = new ScopeTable(outerScopeTable);
        this.blockStatements = new BlockStatements(this.scopeTable);
    }

    @Override
    public String produce() {
        return this.verify("{" + "System.out.println(\"method\");" + blockStatements.produce() + "}");
    }
}
