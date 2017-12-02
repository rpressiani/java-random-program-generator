package system.model.nodes.statements;

//blockStatement
//        :	localVariableDeclarationStatement
//        |	classDeclaration
//        |	statement
//        ;

//TODO        :	localVariableDeclarationStatement
//TODO        |	classDeclaration

import system.model.nodes.Node;

public class BlockStatement implements Node{

    private IBlockStatement statement;

    BlockStatement() {
        this.statement = new LocalVariableDeclarationStatement();
    }

    BlockStatement(String type) {
        this.statement = new Statement(type);
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
