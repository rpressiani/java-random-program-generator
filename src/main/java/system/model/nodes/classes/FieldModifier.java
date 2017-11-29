package system.model.nodes.classes;

//fieldModifier
//        :	annotation
//        |	'public'
//        |	'protected'
//        |	'private'
//        |	'static'
//        |	'final'
//        |	'transient'
//        |	'volatile'
//        ;

import system.model.nodes.Node;

public class FieldModifier implements Node {
    @Override
    public String produce() {
//    TODO: Still need to be implemented
        return this.verify("public ");
    }
}
