package system.model.nodes.interfaces;

import system.model.nodes.Node;

//interfaceMethodModifier
//        :	annotation
//        |	'public'
//        |	'abstract'
//        |	'default'
//        |	'static'
//        |	'strictfp'
//        ;

public class InterfaceMethodModifier implements Node{
    @Override
    public String produce() {
        return this.verify("public");
    }
}
