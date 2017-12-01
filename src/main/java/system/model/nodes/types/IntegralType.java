package system.model.nodes.types;

//integralType
//        :	'byte'
//        |	'short'
//        |	'int'
//        |	'long'
//        |	'char'
//        ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntegralType implements IUnannType {

    private String type;

    IntegralType() {

        List<String> types = new ArrayList<String>() {{
            add("byte");
            add("short");
            add("int");
            add("long");
            add("char");
        }};

        this.type = types.get(new Random().nextInt(types.size() - 1));
    }

    @Override
    public String produce() {
//        TODO implements other types
        return this.verify( this.type);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
