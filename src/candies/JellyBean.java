package candies;

public class JellyBean extends BaseCandy implements Box {

    public JellyBean(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }

    @Override
    public BaseCandy newCandy(String name, int weight, int price, String unic) {
        return new JellyBean(name, weight, price, unic);
    }

}
