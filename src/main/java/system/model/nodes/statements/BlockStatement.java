package system.model.nodes.statements;

//blockStatement
//        :	localVariableDeclarationStatement
//        |	classDeclaration
//        |	statement
//        ;

//TODO        |	classDeclaration

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;

public class BlockStatement implements IBlockStatement{

    private IBlockStatement statement;

    BlockStatement(ScopeTable scopeTable, STKey key) {
        this.statement = new LocalVariableDeclarationStatement(scopeTable, key);
//        this.statement = new Statement();
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
