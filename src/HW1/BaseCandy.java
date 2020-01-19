package HW1;

public abstract class BaseCandy {
    String name;
    int weight;
    int price;
    String unic;

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    BaseCandy(String name, int weight, int price, String unic) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.unic = unic;
        Box.box.add(this);
    }
}
