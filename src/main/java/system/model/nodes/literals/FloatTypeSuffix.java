package system.model.nodes.literals;

import system.model.nodes.Node;
import utils.RegexGen;

//FloatTypeSuffix
//        :	[fFdD]
//        ;

public class FloatTypeSuffix implements Node{

    private String suffix;

    FloatTypeSuffix() {
        this.suffix = (new RegexGen("[fF]")).get();
    }

    @Override
    public String produce() {
        return this.verify(suffix);
    }
}
