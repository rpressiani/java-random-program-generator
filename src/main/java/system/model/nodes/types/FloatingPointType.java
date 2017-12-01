package system.model.nodes.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloatingPointType implements INumericType {
    private String type;

    FloatingPointType() {

        List<String> types = new ArrayList<String>() {{
            add("float");
            add("double");
        }};

        this.type = types.get(new Random().nextInt(types.size()));
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
