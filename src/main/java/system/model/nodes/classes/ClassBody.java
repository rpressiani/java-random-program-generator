package system.model.nodes.classes;

//classBody
//        :	'{' classBodyDeclaration* '}'
//        ;

import system.controller.Main;
import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class ClassBody implements Node {

    private String mainMethod;
    private List<ClassBodyDeclaration> classBodyDeclarations;

    private int minNumberOfFields = Main.config.getFields().get("min");
    private int maxNumberOfFields = Main.config.getFields().get("max");

    private int minNumberOfMethods = Main.config.getMethods().get("min");
    private int maxNumberOfMethods = Main.config.getMethods().get("max");

    ClassBody(ScopeTable scopeTable) {
        //TODO hardcoded main method
        this.classBodyDeclarations = new ArrayList<>();
        init(scopeTable);

        // new STKey is related to the main method in order to get only static variable from the scopetable
        MethodBody mainMethodBody = new MethodBody(new STKey("void", true), new ScopeTable(scopeTable));

        this.mainMethod = "public static void main(String[] args)" +
                mainMethodBody.produce();

    }

    private void init(ScopeTable scopeTable) {
        // GENERATE FIELDS
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfFields-minNumberOfFields) + minNumberOfFields; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration("field", scopeTable));
        }
        // GENERATE METHODS
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfMethods-minNumberOfMethods) + minNumberOfMethods; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration("method", scopeTable));
        }
    }

    @Override
    public String produce() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (ClassBodyDeclaration dec:this.classBodyDeclarations) {
            builder.append(dec.produce());
        }
        builder.append(this.mainMethod);
        builder.append("}");

        return this.verify(builder.toString());
    }
}
