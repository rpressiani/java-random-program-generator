package system.model.nodes.statements;

//localVariableDeclarationStatement
//        :	localVariableDeclaration ';'
//        ;

public class LocalVariableDeclarationStatement implements IBlockStatement {

    private LocalVariableDeclaration localVariableDeclaration;

    LocalVariableDeclarationStatement() {
        this.localVariableDeclaration = new LocalVariableDeclaration();
    }

    @Override
    public String produce() {
        return this.verify(localVariableDeclaration.produce() + ";");
    }
}
