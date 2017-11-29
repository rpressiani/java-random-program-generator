package system.model.nodes;

//'{' classBodyDeclaration* '}'

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classbody implements Node {

    private String mainMethod;
    private List<String> classBodyDeclarations;

    Classbody() {
        this.mainMethod = "public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello!\");\n" +
                "    }";
        this.classBodyDeclarations = new ArrayList<>();

        for (int i = 0; i < (new Random()).nextInt(2) + 1; i++) {
            this.classBodyDeclarations.add("public void test" + (new Random()).nextInt(100) + "() {" +
                    "System.out.println(\"Ciao\");" +
                    "}");
        }
    }

    @Override
    public String produce() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.mainMethod);
        for (String dec:this.classBodyDeclarations) {
            builder.append(dec);
        }
        builder.append("}");

        return this.verify(builder.toString());
    }
}
