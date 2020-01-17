package candies;

import java.util.ArrayList;
import java.util.Collections;

public interface Box {
    int MAX_CANDY_SIZE = 50;
    int MAX_BOX_SIZE = 300;
    ArrayList<BaseCandy> box = new ArrayList<>();

    BaseCandy newCandy(String name, int weight, int price, String unic);

    default void deleteCandy(int index) {
        for (int i = 0; i < box.size(); i++) {
            box.remove(index);
        }
    }

    default void deleteLastCandy() {
        for (int i = 0; i < box.size(); i++) {
            box.remove(box.size() - 1);
        }
    }

    default int getBoxWeight() {
        int boxWeight = 0;
        for (int i = 0; i < box.size(); i++) {
            boxWeight = boxWeight + box.get(i).weight;
        }
        return boxWeight;
    }

    default int boxPrice() {
        int boxPrice = 0;
        for (int i = 0; i < box.size(); i++) {
            boxPrice = boxPrice + box.get(i).price;
        }
        return boxPrice;
    }

    default void aboutAllCandies() {
        for (BaseCandy item : box) {
            System.out.printf("NAME: %s, WEIGHT: %s, PRICE: %s, INF: %s\n", item.name, item.weight, item.price, item.unic);
        }
    }

    default void reduceWeight() {
        if (boxPrice() > MAX_BOX_SIZE) {
            for (int i = 0; i < box.size(); i++) {
                if (box.get(i).weight > MAX_CANDY_SIZE) {
                    deleteCandy(i);
                }
            }
        }
    }

