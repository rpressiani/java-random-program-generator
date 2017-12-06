package system.model.nodes.classes;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.statements.Block;

//methodBody
//        :	block
//        |	';'
//        ;

//TODO        |	';'

public class MethodBody implements Node {

    private Block block;

    MethodBody(STKey key, ScopeTable scopeTable) {
        this.block = new Block(key, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(block.produce());
    }
}
