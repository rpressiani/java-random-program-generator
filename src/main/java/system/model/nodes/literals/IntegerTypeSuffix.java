package system.model.nodes.literals;

import system.model.STKey;
import system.model.nodes.Node;
import utils.RegexGen;

public class IntegerTypeSuffix implements Node {

    private String suffix;

    IntegerTypeSuffix(STKey key) {
        if (!key.getType().equals("long")) {
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
