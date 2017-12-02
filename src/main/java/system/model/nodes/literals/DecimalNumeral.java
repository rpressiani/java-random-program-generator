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
    private Random rand;

    DecimalNumeral(String type) {

        this.rand = new Random();

        if (rand.nextInt(10) > 0) {
//TODO            this.digits = (new NonZeroDigit()).produce() + (new Digits()).produce();
            switch (type) {
                case "long":
                    this.digits = String.valueOf(rand.nextLong());
                    break;
                case "byte":
                    this.digits = String.valueOf(Math.abs(rand.nextInt(8)));
                    break;
                case "char":
                    this.digits = String.valueOf(Math.abs(rand.nextInt(256)));
                    break;
                case "short":
                    this.digits = String.valueOf(rand.nextInt(Short.MAX_VALUE));
                    break;
                case "int":
                    this.digits = String.valueOf(rand.nextInt());
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
