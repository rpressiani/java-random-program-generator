package system.model.nodes.classes;

//variableDeclaratorList
//        :	variableDeclarator (',' variableDeclarator)*
//        ;

import system.controller.Main;
import system.model.nodes.Node;
import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class VariableDeclaratorList implements Node {

    private List<VariableDeclarator> variableDeclaratorList;

    VariableDeclaratorList(String type) {
        this.variableDeclaratorList = new ArrayList<>();
        int listLen = Main.config.getVariableDeclaratorListLength();

        for (int i = 0; i < RandomGen.getNextInt(listLen) + 1; i++) {
            this.variableDeclaratorList.add(new VariableDeclarator(type));
        }
    }

    public List<VariableDeclarator> getVariableDeclaratorList() {
        return variableDeclaratorList;
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
