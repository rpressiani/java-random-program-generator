package system.model.nodes;

//classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody

public class NormalClassDeclaration implements Node {

    private ClassIdentifier identifier;

    public NormalClassDeclaration() {
        this.identifier = new ClassIdentifier();
    }

    private String classbody = "{public static void main(String[] args) {\n" +
            "        System.out.println(\"Test\");\n" +
            "    }}";

    @Override
    public String produce() {
        return this.verify("class " + this.identifier.produce() + classbody);
    }

}
