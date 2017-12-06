package system.model.nodes.classes;

//fieldDeclaration
//        :	fieldModifier* unannType variableDeclaratorList ';'
//        ;

import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.types.UnannType;

public class FieldDeclaration implements IClassMemberDeclaration {

    private FieldModifier fieldModifier;
    private UnannType unannType;
    private VariableDeclaratorList variableDeclaratorList;

    FieldDeclaration(ScopeTable scopeTable, String memberType) {
        this.fieldModifier = new FieldModifier();
        this.unannType = new UnannType();
        this.variableDeclaratorList = new VariableDeclaratorList(new STKey(this.unannType.getType(), false), memberType, scopeTable);
    }

    @Override
    public String produce() {
        String b = this.fieldModifier.produce() +
                " " +
                this.unannType.produce() +
                " " +
                this.variableDeclaratorList.produce() +
                ";\n";
        return this.verify(b);
    }
}
