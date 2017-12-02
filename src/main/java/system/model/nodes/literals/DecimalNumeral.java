package system.model.nodes.literals;

import system.model.nodes.Node;

import java.util.Random;

//DecimalNumeral
//        :	'0'
//        |	NonZeroDigit (Digits? | Underscores Digits)
//        ;

//TODO Underscores

public class DecimalNumeral implements Node{

    private String digits;

    DecimalNumeral(String type) {
        int rand = (new Random()).nextInt(10);
        if (rand > 0) {
//TODO            this.digits = (new NonZeroDigit()).produce() + (new Digits()).produce();
            switch (type) {
                case "long":
                    this.digits = String.valueOf((new Random()).nextLong());
                    break;
                case "byte":
                    this.digits = String.valueOf(Math.abs((new Random()).nextInt(8)));
                    break;
                case "char":
                    this.digits = String.valueOf(Math.abs((new Random()).nextInt(256)));
                    break;
                case "short":
                    this.digits = String.valueOf((new Random()).nextInt(Short.MAX_VALUE));
                    break;
                case "int":
                    this.digits = String.valueOf((new Random()).nextInt());
                    break;
            }

        } else {
            this.digits = "0";
        }
    }

    @Override
    public String produce() {
        return this.verify(digits);
    }
}
