package system.model.nodes.interfaces;

import system.controller.Main;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

//interfaceBody
//        :	'{' interfaceMemberDeclaration* '}'
//        ;

public class InterfaceBody implements Node {

    private List<InterfaceMemberDeclaration> interfaceMemberDeclarationList;

    InterfaceBody() {
        int maxNumberOfMethods = Main.config.getInterfaces().get("maxMethods");
        int minNumberOfMethods = Main.config.getInterfaces().get("minMethods");

        this.interfaceMemberDeclarationList = new ArrayList<>();

        for (int i = 0; i < RandomGen.getNextInt(maxNumberOfMethods-minNumberOfMethods) + minNumberOfMethods; i++) {
            this.interfaceMemberDeclarationList.add(new InterfaceMemberDeclaration());
        }
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        for (InterfaceMemberDeclaration dec: this.interfaceMemberDeclarationList) {
            b.append(dec.produce());
        }

        return this.verify("{" + b.toString() + "}");
    }
}
