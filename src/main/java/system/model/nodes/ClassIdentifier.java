package system.model.nodes;

import utils.RegexGen;

public class ClassIdentifier extends Identifier {

    ClassIdentifier() {
        this.generex = new RegexGen("[A-Z][a-zA-Z0-9]{6,}");
    }

    @Override
    public String produce() {
        return this.verify(this.generex.get());
    }
}
