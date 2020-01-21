package HW1;

public class Nesquik extends BaseCandy implements Box {
    private Nesquik(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }

    static Nesquik getInstance(String name, int weight, int price, String unic) {
        return new Nesquik(name, weight, price, unic);
    }
}
