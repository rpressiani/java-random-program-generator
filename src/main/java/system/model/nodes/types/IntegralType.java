package system.model.nodes.types;

//integralType
//        :	'byte'
//        |	'short'
//        |	'int'
//        |	'long'
//        |	'char'
//        ;

import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class IntegralType implements INumericType {

    private String type;

    IntegralType() {

        List<String> types = new ArrayList<String>() {{
            add("byte");
            add("short");
            add("int");
            add("long");
            add("char");
        }};

        this.type = types.get(RandomGen.getNextInt(types.size()));
    }

    @Override
    public String produce() {
        return this.verify(this.type);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
