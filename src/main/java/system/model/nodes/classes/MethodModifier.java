package system.model.nodes.classes;

import system.model.nodes.Node;
import utils.RandomGen;

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
    private boolean _static;

    MethodModifier() {
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
