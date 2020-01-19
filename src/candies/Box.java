package candies;

import java.util.ArrayList;
import java.util.Collections;

public interface Box {
    int MAX_CANDY_SIZE = 50;
    int MAX_BOX_SIZE = 300;
    int MAX_BOX_PRICE = 400;
    int MAX_CANDY_PRICE = 50;
    ArrayList<BaseCandy> box = new ArrayList<>();

    default void deleteCandy(int index) {
        for (int i = 0; i < box.size(); i++) {
            if (index == i) {
                box.remove(index);
            }
        }
    }

    default void deleteLastCandy() {
        for (int i = box.size() - 1; i < box.size(); i++) {
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
        System.out.println("BOX PRICE: " + boxPrice);
        return boxPrice;
    }

    default void aboutAllCandies() {
        for (BaseCandy item : box) {
            System.out.printf("NAME: %s, WEIGHT: %s, PRICE: %s, INF: %s\n", item.name, item.weight, item.price, item.unic);
        }
    }

    default void reduceWeight() {
        BaseCandy tmp;
        if (getBoxWeight() > MAX_BOX_SIZE) {

    }
}
    }

            }

default void reducePrice(){
        if(boxPrice()>MAX_BOX_PRICE){
        for(int i=0;i<box.size();i++){
        if(box.get(i).price>MAX_CANDY_PRICE){
        deleteCandy(i);
        }
        }
        }
        }
        }

