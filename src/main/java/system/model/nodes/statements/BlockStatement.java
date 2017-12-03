package system.model.nodes.statements;

//blockStatement
//        :	localVariableDeclarationStatement
//        |	classDeclaration
//        |	statement
//        ;

//TODO        |	classDeclaration

import system.model.ScopeTable;
import system.model.nodes.Node;

public class BlockStatement implements Node{

    private IBlockStatement statement;

    BlockStatement(ScopeTable scopeTable) {
        this.statement = new LocalVariableDeclarationStatement(scopeTable);
//        this.statement = new Statement();
    }

    BlockStatement(String type, ScopeTable scopeTable) {
        this.statement = new Statement(type, scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
