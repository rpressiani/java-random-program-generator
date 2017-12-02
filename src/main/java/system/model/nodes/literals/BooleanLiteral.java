package system.model.nodes.literals;

import utils.RandomGen;

//BooleanLiteral
//        :	'true'
//        |	'false'
//        ;

public class BooleanLiteral implements ILiteral {

    private String boo;

    BooleanLiteral() {
        if (RandomGen.getNextInt(2) > 1) {
            this.boo = "true";
        } else {
            this.boo = "false";
        }

    }

    @Override
    public String produce() {
        return this.verify(boo);
    }
}
