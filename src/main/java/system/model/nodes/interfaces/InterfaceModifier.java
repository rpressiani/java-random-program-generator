package system.model.nodes.interfaces;

import system.model.nodes.Node;

//interfaceModifier
//        :	annotation
//        |	'public'
//        |	'protected'
//        |	'private'
//        |	'abstract'
//        |	'static'
//        |	'strictfp'
//        ;

public class InterfaceModifier implements Node {

    @Override
    public String produce() {
        return this.verify("public");
    }
}
