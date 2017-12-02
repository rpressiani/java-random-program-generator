package system.model.nodes.literals;

import system.model.nodes.Node;
import utils.RegexGen;

//        Digits
//        :	Digit (DigitsAndUnderscores? Digit)?
//        ;

//        Digit
//        :	'0'
//        |	NonZeroDigit
//        ;

//TODO DigitsAndUnderscores?

public class Digits implements Node {

    private String digits;

    Digits() {
        this.digits = (new RegexGen("[0-9]+")).get();
    }

    @Override
    public String produce() {
        return this.verify(digits);
    }

}
