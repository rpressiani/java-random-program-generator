package system.model.nodes.classes;

//classBody
//        :	'{' classBodyDeclaration* '}'
//        ;

import system.controller.Main;
import system.model.STEntry;
import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class ClassBody implements Node {

    private final boolean implementsInterface;
    private final ScopeTable overriddenMethods;
    private boolean produceMain;

    private String mainMethod;
    private List<ClassBodyDeclaration> classBodyDeclarations;
    private List<OverriddenMethod> overriddenMethodList;

    private int minNumberOfFields = Main.config.getFields().get("min");
    private int maxNumberOfFields = Main.config.getFields().get("max");

    private int minNumberOfMethods = Main.config.getMethods().get("min");
    private int maxNumberOfMethods = Main.config.getMethods().get("max");

    ClassBody(ScopeTable scopeTable, boolean produceMain, boolean implementsInterface, ScopeTable overriddenMethods) {
        this.implementsInterface = implementsInterface;
        this.overriddenMethods = overriddenMethods;
        //TODO hardcoded main method
        this.classBodyDeclarations = new ArrayList<>();
        this.produceMain = produceMain;
        init(scopeTable);

        // new STKey is related to the main method in order to get only static variable from the scopetable
        MethodBody mainMethodBody = new MethodBody(new STKey("void", true), new ScopeTable(scopeTable, true));

        if(this.produceMain) {
            this.mainMethod = "public static void main(String[] args)" +
                    mainMethodBody.produce();
        }

    }

    private void init(ScopeTable scopeTable) {

        // GENERATE FIELDS
        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfFields-minNumberOfFields) + minNumberOfFields; i++) {
            this.classBodyDeclarations.add(new ClassBodyDeclaration("field", scopeTable));
        }

        if (this.implementsInterface) {
            this.overriddenMethodList = new ArrayList<>();
            for (STEntry method : this.overriddenMethods.getMethods()) {
                this.overriddenMethodList.add(new OverriddenMethod(method, scopeTable));
            }
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
        if (this.implementsInterface) {
            for (OverriddenMethod method: overriddenMethodList) {
                builder.append(method.produce());
            }
        }
        if(this.produceMain) {
            builder.append(this.mainMethod);
        }
        builder.append("}");

        return this.verify(builder.toString());
    }
}
