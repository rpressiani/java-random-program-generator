package system.model.nodes.classes;

//variableDeclaratorList
//        :	variableDeclarator (',' variableDeclarator)*
//        ;

import system.controller.Main;
import system.model.STEntry;
import system.model.STKey;
import system.model.ScopeTable;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class VariableDeclaratorList implements Node {

    private List<VariableDeclarator> variableDeclaratorList;

//    TODO remove varType from VariableDeclaratorList constructor
    public VariableDeclaratorList(STKey key, String varType, ScopeTable scopeTable) {
        this.variableDeclaratorList = new ArrayList<>();
        int listLen = Main.config.getVariableDeclaratorListLength();

        for (int i = 0; i < RandomGen.getNextInt(listLen) + 1; i++) {
            VariableDeclarator newVar = new VariableDeclarator(key, scopeTable);
            if (varType.equals("field")) {
                scopeTable.addField(
                        key.getType(),
                        new STEntry(key.getType(), newVar.getVariableDeclaratorId(), key.isStatic())
                );
            } else {
                scopeTable.addVariable(
                        key.getType(),
                        new STEntry(key.getType(), newVar.getVariableDeclaratorId(), key.isStatic())
                );
            }
            this.variableDeclaratorList.add(newVar);
        }
    }

    @Override
    public String produce() {
        StringBuilder b = new StringBuilder();
        b.append(this.variableDeclaratorList.get(0).produce());

        for (int i = 1; i < this.variableDeclaratorList.size() ; i++) {
            b.append(",").append(this.variableDeclaratorList.get(i).produce());
        }

        return this.verify(b.toString());
    }
}
