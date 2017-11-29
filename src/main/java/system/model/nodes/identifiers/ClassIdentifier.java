package system.model.nodes.identifiers;

import utils.RegexGen;

public class ClassIdentifier extends Identifier {
//    TODO hardcoded string length
    public ClassIdentifier() {
        this.generex = new RegexGen("[A-Z][a-zA-Z0-9]{6,}");
    }

    @Override
    public String produce() {
        return this.verify(this.generex.get());
    }
}
