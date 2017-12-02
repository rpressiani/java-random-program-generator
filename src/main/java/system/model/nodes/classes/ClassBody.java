package system.model.nodes.classes;

//classBody
//        :	'{' classBodyDeclaration* '}'
//        ;

import system.controller.Main;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class ClassBody implements Node {

    private String mainMethod;
    private List<ClassBodyDeclaration> classBodyDeclarations;

    private int minNumberOfFields = Main.config.getFields().get("min");
    private int maxNumberOfFields = Main.config.getFields().get("max");

    ClassBody() {
        //TODO hardcoded main method
        this.mainMethod = "public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello!\");\n" +
                "    }";
        this.classBodyDeclarations = new ArrayList<>();
        init();
    }

    private void init() {
        //TODO hardcoded random
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfFields-minNumberOfFields) + minNumberOfFields; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration());
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
