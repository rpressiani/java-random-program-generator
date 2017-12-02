package system.model.nodes.identifiers;

import system.controller.Main;
import utils.RegexGen;

public class ClassIdentifier extends Identifier {

    private String identifier;

    public ClassIdentifier() {
        String len = Main.config.getIdentifier().get("len");
        this.generex = new RegexGen("[A-Z][a-zA-Z0-9]{" + len + ",}");

        this.identifier = this.generex.get();
    }

    public ClassIdentifier(String className) {
        this.identifier = className;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String produce() {
        return this.verify(this.identifier);
    }
}
