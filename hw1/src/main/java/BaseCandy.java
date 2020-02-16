
abstract public class BaseCandy {
    public String name;
    public int weight;
    public int price;
    public String unic;

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getUnic() {
        return unic;
    }

    public String getName() {
        return name;
    }

    public BaseCandy(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        Box.box.add(this);
    }
}
