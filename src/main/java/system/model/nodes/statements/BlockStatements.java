package system.model.nodes.statements;

import system.model.nodes.Node;

import java.util.ArrayList;
import java.util.List;

//blockStatements
//        :	blockStatement+
//        ;

public class BlockStatements implements Node{

    private List<BlockStatement> blockStatementList;

    BlockStatements(String type) {
        this.blockStatementList = new ArrayList<>();

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
