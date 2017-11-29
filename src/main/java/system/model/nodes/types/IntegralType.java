package system.model.nodes.types;

//integralType
//        :	'byte'
//        |	'short'
//        |	'int'
//        |	'long'
//        |	'char'
//        ;

import system.model.nodes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntegralType implements Node {

    List<String> types = new ArrayList<String>(){{
        add("byte");
        add("short");
        add("int");
        add("long");
        add("char");
    }};

    @Override
    public String produce() {
//        TODO implements other types
        return this.verify(types.get(new Random().nextInt(types.size() - 1)) + " ");
    }
}
