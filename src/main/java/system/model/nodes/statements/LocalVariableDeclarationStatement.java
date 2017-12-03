package system.model.nodes.statements;

//localVariableDeclarationStatement
//        :	localVariableDeclaration ';'
//        ;

import system.model.ScopeTable;

public class LocalVariableDeclarationStatement implements IBlockStatement {

    private LocalVariableDeclaration localVariableDeclaration;

    LocalVariableDeclarationStatement(ScopeTable scopeTable) {
        this.localVariableDeclaration = new LocalVariableDeclaration(scopeTable);
    }

    @Override
    public String produce() {
        return this.verify(localVariableDeclaration.produce() + ";");
    }
}
