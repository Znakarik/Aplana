package candies;

import java.util.ArrayList;

public interface Box {
    ArrayList<BaseCandy> items = new ArrayList<>();

    BaseCandy newCandy(String name, int weight, int price, String unic);

    default void deleteCandy(int index) {
        for (int i = 0; i < items.size(); i++) {
            items.remove(index);
        }
    }

    default void deleteLastCandy() {
        for (int i = 0; i < items.size(); i++) {
            items.remove(items.size() - 1);
        }
    }

    default int getBoxWeight() {
        int boxWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            boxWeight = boxWeight + items.get(i).weight;
        }
        return boxWeight;
    }

    default int boxPrice() {
        int boxPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            boxPrice = boxPrice + items.get(i).price;
        }
        return boxPrice;
    }

    default void aboutAllCandies() {
        for (BaseCandy item : items) {
            System.out.printf("NAME: %s, WEIGHT: %s, PRICE: %s, INF: %s\n", item.name, item.weight, item.price, item.unic);
        }
    }

    default void reduceWeight() {

    }
}
