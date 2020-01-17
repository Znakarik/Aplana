package candies;

public abstract class BaseCandy {
    String name;
    int weight;
    int price;
    String unic;



    BaseCandy(String name, int weight, int price, String unic) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.unic = unic;
        Box.box.add(this);
    }
}
