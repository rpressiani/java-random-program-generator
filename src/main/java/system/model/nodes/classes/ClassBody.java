package system.model.nodes.classes;

//classBody
//        :	'{' classBodyDeclaration* '}'
//        ;

import system.controller.Main;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.Logger;
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
        this.mainMethod = "public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello!\");\n" +
                "    }";
        this.classBodyDeclarations = new ArrayList<>();
        init(scopeTable);
    }

    private void init(ScopeTable scopeTable) {
//        GENERATE FIELDS
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfFields-minNumberOfFields) + minNumberOfFields; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration("field", scopeTable));
        }
        Logger.log("classbody", "End fields generation");
//        GENERATE METHODS
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfMethods-minNumberOfMethods) + minNumberOfMethods; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration("method", scopeTable));
        }
    }

    public List<ClassBodyDeclaration> getDeclarations() {
        return classBodyDeclarations;
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
