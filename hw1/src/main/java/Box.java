import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public interface Box {
    int MAX_BOX_SIZE = 20;
    int MAX_BOX_PRICE = 20;
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
        System.out.println("BOX WEIGHT: " + boxWeight);
        return boxWeight;
    }

    default int boxPrice() {
        int boxPrice = 0;
        for (BaseCandy baseCandy : box) {
            boxPrice = boxPrice + baseCandy.price;
        }
        System.out.println("BOX PRICE: " + boxPrice);
        return boxPrice;
    }

    default void aboutAllCandies() {
        for (BaseCandy item : box) {
            System.out.printf("NAME: %s, WEIGHT: %s, PRICE: %s, UNIC: %s\n", item.name, item.weight, item.price, item.unic);
        }
    }

    default void reduceWeight() {
        box.sort(Comparator.comparing(BaseCandy::getWeight));
        Collections.reverse(box);
        while (getBoxWeight() > MAX_BOX_SIZE) {
            System.err.println("Your box is too heavy!");
            System.err.println("Deleting...\n ");
            deleteLastCandy();
        }
    }

    default void reducePrice() {
        box.sort(Comparator.comparing(BaseCandy::getPrice));
        Collections.reverse(box);
        if (boxPrice() > MAX_BOX_PRICE) {
            System.err.println("Your box is too expensive\n");
            System.err.println("Deleting...\n");
            deleteLastCandy();
        }
    }
}


