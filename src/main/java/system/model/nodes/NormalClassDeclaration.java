package system.model.nodes;

//classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody

public class NormalClassDeclaration implements Node {

    String identifier = "Main";
    String classbody = "{public static void main(String[] args) {\n" +
            "        System.out.println(\"Test\");\n" +
            "    }}";

    @Override
    public String toString() {
        return "class " + identifier + classbody;
    }
}
