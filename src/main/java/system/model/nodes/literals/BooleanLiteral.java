package system.model.nodes.literals;

import java.util.Random;

//BooleanLiteral
//        :	'true'
//        |	'false'
//        ;

public class BooleanLiteral implements ILiteral {

    String boo;

    public BooleanLiteral() {
        if ((new Random()).nextInt(2) > 1) {
            this.boo = "True";
        } else {
            this.boo = "False";
        }
    }

    @Override
    public String produce() {
        return this.verify(boo);
    }
}
