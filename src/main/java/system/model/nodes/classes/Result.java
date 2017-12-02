package system.model.nodes.classes;

import system.model.nodes.Node;
import system.model.nodes.types.UnannType;
import utils.RandomGen;

//result
//        :	unannType
//        |	'void'
//        ;

public class Result implements Node{

    private String type;

    Result() {
        if (RandomGen.getNextInt(2) == 1) {
            this.type = new UnannType().produce();
        } else {
            this.type = "void";
        }
    }

    public String getType() {
        return type;
    }

    @Override
    public String produce() {
        return this.verify(type);
    }
}
