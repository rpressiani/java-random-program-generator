package system.model.nodes.statements;

import system.model.nodes.Node;

//block
//        :	'{' blockStatements? '}'
//        ;

//TODO ?

public class Block implements Node{

    private BlockStatements blockStatements;

    public Block(String type) {
        this.blockStatements = new BlockStatements(type);
    }

    @Override
    public String produce() {
        return this.verify("{" + "System.out.println(\"method\");" + blockStatements.produce() + "}");
    }
}
