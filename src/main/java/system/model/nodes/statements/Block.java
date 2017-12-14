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

    public Block(STKey key, ScopeTable outerScopeTable) {
        ScopeTable scopeTable = new ScopeTable(outerScopeTable, outerScopeTable.isStaticScope());
        this.blockStatements = new BlockStatements(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify("{" + blockStatements.produce() + "}");
    }
}
