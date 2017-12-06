package system.model.nodes.statements;

//localVariableDeclarationStatement
//        :	localVariableDeclaration ';'
//        ;

import system.model.STKey;
import system.model.ScopeTable;

public class LocalVariableDeclarationStatement implements IBlockStatement {

    private LocalVariableDeclaration localVariableDeclaration;

    LocalVariableDeclarationStatement(ScopeTable scopeTable, STKey key) {
        this.localVariableDeclaration = new LocalVariableDeclaration(scopeTable, key);
    }

    @Override
    public String produce() {
        return this.verify(localVariableDeclaration.produce() + ";");
    }
}
