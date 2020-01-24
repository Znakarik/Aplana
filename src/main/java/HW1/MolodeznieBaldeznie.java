package HW1;

public class MolodeznieBaldeznie extends BaseCandy implements Box {

    private MolodeznieBaldeznie(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }

    static MolodeznieBaldeznie getInstance(String name, int weight, int price, String unic) {
        return new MolodeznieBaldeznie(name, weight, price, unic);
    }
}
