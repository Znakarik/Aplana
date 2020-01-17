package candies;

public class MolodeznieBaldeznie extends BaseCandy implements Box {

    public MolodeznieBaldeznie(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }

    @Override
    public BaseCandy newCandy(String name, int weight, int price, String unic) {
        return new MolodeznieBaldeznie(name, weight, price, unic);
    }
}
