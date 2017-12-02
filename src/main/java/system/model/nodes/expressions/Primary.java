package system.model.nodes.expressions;

import system.model.nodes.Node;

//primary
//        :	(	primaryNoNewArray_lfno_primary
//        |	arrayCreationExpression
//        )
//        (	primaryNoNewArray_lf_primary
//        )*
//        ;

//TODO        |	arrayCreationExpression
//TODO        )
//TODO        (	primaryNoNewArray_lf_primary
//TODO        )*

public class Primary implements Node{

    private PrimaryNoNewArray_lfno_primary primaryNoNewArray_lfno_primary;

    public Primary(String type) {
        this.primaryNoNewArray_lfno_primary = new PrimaryNoNewArray_lfno_primary(type);
    }

    @Override
    public String produce() {
        return this.verify(primaryNoNewArray_lfno_primary.produce());
    }
}
