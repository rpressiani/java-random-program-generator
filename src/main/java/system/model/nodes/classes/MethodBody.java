package system.model.nodes.classes;

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

    MethodBody(String type, ScopeTable scopeTable) {
        this.block = new Block(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(block.produce());
    }
}
