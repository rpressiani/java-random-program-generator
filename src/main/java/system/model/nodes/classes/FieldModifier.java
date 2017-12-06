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
import utils.RandomGen;

//TODO implement modifiers other than visibility
public class FieldModifier implements Node {

    private Visibility visibility;
    private boolean _static;

    FieldModifier() {
        this.visibility = Visibility.getRandomVisibility();
        this._static = RandomGen.getNextInt(4) == 0;
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append(this.visibility.toString().toLowerCase());
        if (this.isStatic()) b.append(" static");
        return this.verify(b.toString());
    }

    public boolean isStatic() {
        return _static;
    }
}
