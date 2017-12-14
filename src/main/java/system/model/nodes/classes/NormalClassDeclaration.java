package system.model.nodes.classes;

//normalClassDeclaration
//        :	classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
//        ;

import system.controller.Main;
import system.model.ScopeTable;
import system.model.nodes.Node;
import system.model.nodes.identifiers.ClassIdentifier;
import utils.RandomGen;

import java.util.Map;

public class NormalClassDeclaration implements Node {

    private ClassIdentifier identifier;
    private ClassBody classBody;
    private ScopeTable scopeTable;
    private SuperInterfaces superInterfaces;
    private boolean implementsInterface = false;
    private ScopeTable overriddenMethods = null;

    public NormalClassDeclaration(String className, boolean produceMain, Map<String, ScopeTable> interfaceTables) {
        if (RandomGen.getNextInt(Main.config.getClasses().get("implementsInterfaceRatio")) == 0) {
            this.implementsInterface = true;
            this.superInterfaces = new SuperInterfaces(interfaceTables);
            this.overriddenMethods = interfaceTables.get(this.superInterfaces.getInterfaceName());
        }

        this.identifier = new ClassIdentifier(className);
        this.scopeTable = new ScopeTable();
        this.classBody = new ClassBody(scopeTable, produceMain, implementsInterface, this.overriddenMethods);
    }

    public NormalClassDeclaration(String className, boolean produceMain, Map<String, ScopeTable> interfaceTables, ScopeTable scopeTable) {
        if (RandomGen.getNextInt(Main.config.getClasses().get("implementsInterfaceRatio")) == 0) {
            this.implementsInterface = true;
            this.superInterfaces = new SuperInterfaces(interfaceTables);
            this.overriddenMethods = interfaceTables.get(this.superInterfaces.getInterfaceName());
        }

        this.identifier = new ClassIdentifier(className);
        this.scopeTable = scopeTable;
        this.classBody = new ClassBody(new ScopeTable(scopeTable, true), produceMain, implementsInterface, this.overriddenMethods);
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append("class ").append(this.identifier.produce());
        if (implementsInterface) {
            b.append(" ").append(this.superInterfaces.produce());
        }
        b.append(classBody.produce());

        return this.verify(b.toString());
    }

}
