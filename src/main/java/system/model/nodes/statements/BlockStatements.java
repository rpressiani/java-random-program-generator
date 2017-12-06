package system.model.nodes.statements;

import system.controller.Main;
import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

//blockStatements
//        :	blockStatement+
//        ;

public class BlockStatements implements Node{

    private List<IBlockStatement> blockStatementList;

    BlockStatements(STKey key, ScopeTable scopeTable) {
        this.blockStatementList = new ArrayList<>();

        int maxNumberOfStatements = Main.config.getStatements().get("max");
        int minNumberOfStatements = Main.config.getStatements().get("min");

        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfStatements - minNumberOfStatements) + minNumberOfStatements; i++) {
            this.blockStatementList.add(new BlockStatement(scopeTable, key));
        }

        if (!key.getType().equals("void")) {
            this.blockStatementList.add(new ReturnStatement(scopeTable, key));
        }
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        for (IBlockStatement blockStatement: this.blockStatementList) {
            b.append(blockStatement.produce());
        }

        return this.verify(b.toString());
    }
}
