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

//TODO implement modifiers other than visibility
public class FieldModifier implements Node {

    private Visibility visibility;

    FieldModifier() {
        this.visibility = Visibility.getRandomVisibility();
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public String produce() {
        return this.verify(this.visibility.toString().toLowerCase());
    }


}
