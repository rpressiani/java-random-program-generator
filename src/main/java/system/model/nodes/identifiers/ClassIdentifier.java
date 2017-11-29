package system.model.nodes.identifiers;

import system.controller.Main;
import utils.RegexGen;

public class ClassIdentifier extends Identifier {
//    TODO hardcoded string length
    public ClassIdentifier() {
        String len = Main.config.getIdentifier().get("len");
        this.generex = new RegexGen("[A-Z][a-zA-Z0-9]{" + len + ",}");
    }

    @Override
    public String produce() {
        return this.verify(this.generex.get());
    }
}
