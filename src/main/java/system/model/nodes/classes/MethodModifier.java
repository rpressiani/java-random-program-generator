package system.model.nodes.classes;

import system.model.nodes.Node;

//methodModifier
//        :	annotation
//        |	'public'
//        |	'protected'
//        |	'private'
//        |	'abstract'
//        |	'static'
//        |	'final'
//        |	'synchronized'
//        |	'native'
//        |	'strictfp'
//        ;

//TODO finish implementations

public class MethodModifier implements Node{

    private Visibility visibility;

    MethodModifier() {
        this.visibility = Visibility.getRandomVisibility();
    }

    public Visibility getVisibility() {
        return visibility;
    }

    @Override
    public String produce() {
        return this.verify(this.visibility.toString().toLowerCase());
    }
}
