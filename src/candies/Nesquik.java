package candies;

public class Nesquik extends BaseCandy  implements Box{
    public Nesquik(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }

    @Override
    public BaseCandy newCandy(String name, int weight, int price, String unic) {
        return new Nesquik(name, weight, price, unic);
    }
}
