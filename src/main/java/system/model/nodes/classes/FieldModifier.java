package system.model.nodes.classes;

//fieldModifier
//        :	annotation
//        |	'public'
//        |	'protected'
//        |	'private'
//        |	'static'
//        |	'final'
//        |	'transient'
//        |	'volatile'
//        ;

import system.model.nodes.Node;

public class FieldModifier implements Node {

    private static Visibility visibility;

    public FieldModifier() {
        this.visibility = Visibility.getRandomVisibility();
    }

    public static Visibility getVisibility() {
        return visibility;
    }

    @Override
    public String produce() {
        return this.verify(this.visibility.toString().toLowerCase());
    }


}
