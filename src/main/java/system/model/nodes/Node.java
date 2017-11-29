package system.model.nodes;

public interface Node {

    String produce();

    default String verify(String prod) {
        return prod;
    };
}
