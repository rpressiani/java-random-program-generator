package system.model.nodes.statements;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

//block
//        :	'{' blockStatements? '}'
//        ;

//TODO ?

public class Block implements Node{

    private BlockStatements blockStatements;
    private ScopeTable scopeTable;

    public Block(STKey key, ScopeTable outerScopeTable) {
        this.scopeTable = new ScopeTable(outerScopeTable);
        this.blockStatements = new BlockStatements(key, this.scopeTable);
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
