package system.model.nodes.identifiers;

import utils.RegexGen;

public class GenericIdentifier extends Identifier {
    //    TODO hardcoded string length
    public GenericIdentifier() {
        this.generex = new RegexGen("[A-Za-z][a-zA-Z0-9]{6,}");
    }

    @Override
    public String produce() {
        return this.verify(this.generex.get());
    }
}
