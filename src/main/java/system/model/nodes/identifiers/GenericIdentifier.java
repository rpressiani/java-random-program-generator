package system.model.nodes.identifiers;

import utils.RegexGen;

public class GenericIdentifier extends Identifier {

    String genericIdentifier;

    //    TODO hardcoded string length
    public GenericIdentifier() {
        this.generex = new RegexGen("[A-Za-z][a-zA-Z0-9]{6,}");
        this.genericIdentifier = this.generex.get();
    }

    public String getIdentifier() {
        return this.genericIdentifier;
    }

    @Override
    public String produce() {
        return this.verify(this.genericIdentifier);
    }
}
