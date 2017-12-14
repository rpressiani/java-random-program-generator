package system.model.nodes.interfaces;

import system.model.nodes.Node;
import system.model.nodes.classes.Visibility;

//interfaceModifier
//        :	annotation
//        |	'public'
//        |	'protected'
//        |	'private'
//        |	'abstract'
//        |	'static'
//        |	'strictfp'
//        ;

public class InterfaceModifier implements Node {

    private Visibility visibility;

    InterfaceModifier() {
        this.visibility = system.model.nodes.classes.Visibility.getRandomVisibility();
    }

    @Override
    public String produce() {
        return this.verify(this.visibility.toString().toLowerCase());
    }
}
