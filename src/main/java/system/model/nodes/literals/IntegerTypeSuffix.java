package system.model.nodes.literals;

import system.model.nodes.Node;
import utils.RegexGen;

public class IntegerTypeSuffix implements Node {

    private String suffix;

    IntegerTypeSuffix(String type) {
        if (!type.equals("long")) {
            this.suffix = "";
        } else {
            suffix = (new RegexGen("[lL]")).get();
        }

    }

    @Override
    public String produce() {
        return this.verify(suffix);
    }
}
