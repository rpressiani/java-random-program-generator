package system.model.nodes.types;

//integralType
//        :	'byte'
//        |	'short'
//        |	'int'
//        |	'long'
//        |	'char'
//        ;

import system.model.nodes.Node;

public class IntegralType implements Node {
    @Override
    public String produce() {
//        TODO implements other types
        return this.verify("int ");
    }
}
