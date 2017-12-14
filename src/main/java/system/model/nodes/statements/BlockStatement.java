package system.model.nodes.statements;

//blockStatement
//        :	localVariableDeclarationStatement
//        |	classDeclaration
//        |	statement
//        ;

//TODO        |	classDeclaration

import system.model.STKey;
import system.model.ScopeTable;
import utils.RandomGen;

public class BlockStatement implements IBlockStatement{

    private IBlockStatement statement;

    BlockStatement(ScopeTable scopeTable, STKey key) {
        if (RandomGen.getNextInt(2) == 1) {
            if (scopeTable.isStaticScope() &&
                    (scopeTable.getRandomField(new STKey(null, true)).getIdentifier() == null ||
                            scopeTable.getRandomMethod(new STKey(null, true)).getIdentifier() == null)) {
                this.statement = new LocalVariableDeclarationStatement(scopeTable, key);
            } else {
                this.statement = new Statement(key, scopeTable);
            }
        } else {
            this.statement = new LocalVariableDeclarationStatement(scopeTable, key);
        }
    }

    @Override
    public String produce() {
        return this.verify(statement.produce());
    }
}
