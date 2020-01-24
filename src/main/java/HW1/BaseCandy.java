package HW1;

abstract class BaseCandy {
    String name;
    int weight;
    int price;
    String unic;

    int getWeight() {
        return weight;
    }

    int getPrice() {
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
