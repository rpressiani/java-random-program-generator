package system.model.nodes.statements;

import system.controller.Main;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

//blockStatements
//        :	blockStatement+
//        ;

public class BlockStatements implements Node{

    private List<BlockStatement> blockStatementList;

    BlockStatements(String type) {
        this.blockStatementList = new ArrayList<>();

        int maxNumberOfStatements = Main.config.getStatements().get("max");
        int minNumberOfStatements = Main.config.getStatements().get("min");
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfStatements - minNumberOfStatements) + minNumberOfStatements; i++) {
            this.blockStatementList.add(new BlockStatement());
        }

        if (!type.equals("void")) {
            this.blockStatementList.add(new BlockStatement(type));
        }
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        for (BlockStatement blockStatement: this.blockStatementList) {
            b.append(blockStatement.produce());
        }

        return this.verify(b.toString());
    }
}
