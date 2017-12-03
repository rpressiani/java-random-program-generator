package system.model.nodes.statements;

//localVariableDeclaration
//        :	variableModifier* unannType variableDeclaratorList
//        ;

import system.model.ScopeTable;
import system.model.nodes.classes.VariableDeclaratorList;
import system.model.nodes.classes.VariableModifier;
import system.model.nodes.types.UnannType;

public class LocalVariableDeclaration implements IBlockStatement{

    private VariableModifier variableModifier;
    private UnannType unannType;
    private VariableDeclaratorList variableDeclaratorList;

    LocalVariableDeclaration(ScopeTable scopeTable) {
        this.variableModifier = new VariableModifier();
        this.unannType = new UnannType();
        this.variableDeclaratorList = new VariableDeclaratorList(this.unannType.getType(), scopeTable);
    }

    public VariableModifier getVariableModifier() {
        return variableModifier;
    }

    public UnannType getUnannType() {
        return unannType;
    }

    public VariableDeclaratorList getVariableDeclaratorList() {
        return variableDeclaratorList;
    }

    @Override
    public String produce() {
        String b = this.variableModifier.produce() +
                " " +
                this.unannType.produce() +
                " " +
                this.variableDeclaratorList.produce();
        return this.verify(b);
    }
}
