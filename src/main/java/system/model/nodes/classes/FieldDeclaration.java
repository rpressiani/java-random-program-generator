package system.model.nodes.classes;

//fieldDeclaration
//        :	fieldModifier* unannType variableDeclaratorList ';'
//        ;

import system.model.nodes.Node;
import system.model.nodes.types.UnannType;

public class FieldDeclaration implements Node {

    private FieldModifier fieldModifier;
    private UnannType unannType;
    private VariableDeclaratorList variableDeclaratorList;

    FieldDeclaration() {
        this.fieldModifier = new FieldModifier();
        this.unannType = new UnannType();
        this.variableDeclaratorList = new VariableDeclaratorList(this.unannType.getType());
    }

    public FieldModifier getFieldModifier() {
        return fieldModifier;
    }

    public UnannType getUnannType() {
        return unannType;
    }

    public VariableDeclaratorList getVariableDeclaratorList() {
        return variableDeclaratorList;
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append(this.fieldModifier.produce());
        b.append(" ");
        b.append(this.unannType.produce());
        b.append(" ");
        b.append(this.variableDeclaratorList.produce());
        b.append(";\n");
        return this.verify(b.toString());
    }
}
