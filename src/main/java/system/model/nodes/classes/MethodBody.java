package system.model.nodes.classes;

import system.model.nodes.Node;
import system.model.nodes.statements.Block;

//methodBody
//        :	block
//        |	';'
//        ;

//TODO        |	';'

public class MethodBody implements Node {

    private Block block;

    MethodBody(String type) {
        this.block = new Block(type);
    }

    @Override
    public String produce() {
        return this.verify(block.produce());
    }
}
