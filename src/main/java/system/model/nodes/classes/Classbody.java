package system.model.nodes.classes;

//'{' classBodyDeclaration* '}'

import system.model.nodes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classbody implements Node {

    private String mainMethod;
    private List<ClassBodyDeclaration> classBodyDeclarations;

    Classbody() {
//TODO hardcoded main method
        this.mainMethod = "public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello!\");\n" +
                "    }";
        this.classBodyDeclarations = new ArrayList<>();

//TODO hardcoded random
        for (int i = 0; i < (new Random()).nextInt(6) + 1; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration());
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
