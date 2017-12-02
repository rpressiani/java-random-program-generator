package system.model.nodes.types;

import utils.RandomGen;

import java.util.ArrayList;
import java.util.List;

public class FloatingPointType implements INumericType {
    private String type;

    FloatingPointType() {

        List<String> types = new ArrayList<String>() {{
            add("float");
            add("double");
        }};

        this.type = types.get(RandomGen.getNextInt(types.size()));
    }

    @Override
    public String produce() {
        return this.verify(this.type);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
